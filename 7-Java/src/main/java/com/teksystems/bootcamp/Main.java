package com.teksystems.bootcamp;

import com.teksystems.bootcamp.additionalnputs.NumberAggregator;
import com.teksystems.bootcamp.expressionSolver.ExpressionParser;
import com.teksystems.bootcamp.expressionSolver.Term;
import com.teksystems.bootcamp.factorByTwo.Node;
import com.teksystems.bootcamp.factorByTwo.NodeCreator;
import com.teksystems.bootcamp.factorByTwo.PointerNode;
import com.teksystems.bootcamp.factorByTwo.ValueNode;
import com.teksystems.bootcamp.findCharacters.CharFinder;
import com.teksystems.bootcamp.gridHopper.BoardGenerator;
import com.teksystems.bootcamp.gridHopper.BoardHopper;
import com.teksystems.bootcamp.gridHopper.LocationPointer;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        printDog();
        runApp();
    }

    private static void runApp() {
        Scanner input = new Scanner(System.in);
        String userChoice;

        boolean isQuit = false;

        do {
            displayMenu();
            userChoice = input.nextLine().toLowerCase();
            if((userChoice.equals("1")) || (userChoice.contains("number")) || (userChoice.contains("aggregator"))) {
                runNumberAggregator();
            } else if((userChoice.equals("2")) || (userChoice.contains("find")) || (userChoice.contains("characters"))) {
                runFindCharacters();
            } else if((userChoice.equals("3")) || (userChoice.contains("factor")) || (userChoice.contains("two"))) {
                runFactorByTwo();
            } else if((userChoice.equals("4")) || (userChoice.contains("grid")) || (userChoice.contains("hopper"))) {
                runGridHopper();
            } else if((userChoice.equals("5")) || (userChoice.contains("expression")) || (userChoice.contains("solver"))) {
                runExpressionSolver();
            } else {
                isQuit = quit();
            }
        } while(!isQuit);
    }

    private static void displayMenu() {
        System.out.println("\n===================");
        System.out.println("     MAIN MENU");
        System.out.println("===================");
        System.out.println("1. Number Aggregator");
        System.out.println("2. Find Characters");
        System.out.println("3. Factor by Two");
        System.out.println("4. Grid Hopper");
        System.out.println("5. Expression Solver\n");
        System.out.println("Please enter your choice ('q' to quit): ");
    }

    private static boolean quit() {
        System.out.println("\nThank you for playing. Come again soon!");
        return true;
    }

    private static void runNumberAggregator() {
        System.out.println();
        Scanner input = new Scanner(System.in);

        boolean isQuitAggregator = false;
        int numberToAdd;
        int total = 0;

        do {
            System.out.println("Enter a number ('q' to quit adding & get total)");
            try {
                numberToAdd = input.nextInt();
                total = NumberAggregator.addNumber(numberToAdd, total);
            } catch (InputMismatchException e) {
                isQuitAggregator = true;
            }
        } while(!isQuitAggregator);
        System.out.println("Your total is: " + total + "\n");

        try {
            TimeUnit.MILLISECONDS.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void runFindCharacters() {
        System.out.println();
        Scanner input = new Scanner(System.in);

        boolean isQuitFinder = false;
        String charactersToFind;
        String stringToSearch;
        Map<Character, List<Integer>> charPositions;
        String userChoice;

        do {
            System.out.println("Enter characters to find");
            charactersToFind = input.nextLine();
            System.out.println("Enter string to search");
            stringToSearch = input.nextLine();
            charPositions = CharFinder.findMatchPositions(charactersToFind, stringToSearch);

            System.out.printf("\n%-10s | %-10s\n", "Character", "Positions");
            System.out.printf("%-10s | %-10s\n", "_________", "__________");
            for(Map.Entry<Character, List<Integer>> entry : charPositions.entrySet()) {
                System.out.printf("%-10s | %-10s\n", "    " + entry.getKey(), entry.getValue());
            }

            System.out.println("\nWould you like to search again? (y/n)");
            userChoice = input.nextLine().toLowerCase();
            isQuitFinder = userChoice.equals("n");
        } while(!isQuitFinder);
    }

    private static void runFactorByTwo() {
        System.out.println();
        Scanner input = new Scanner(System.in);

        boolean isQuitFactoring = false;
        int numberToFactor;
        Node myNode;

        do {
            int numberOfTwos = 0;
            System.out.println("Enter a number ('q' to quit)");
            try {
                numberToFactor = input.nextInt();
                myNode = NodeCreator.createNode(numberToFactor);
                if((myNode instanceof ValueNode) || (myNode instanceof PointerNode)) {
                    numberOfTwos += myNode.getCountOfTwos();
                }
                System.out.println("The number of twos in " + numberToFactor + " is " + numberOfTwos + "\n");
            } catch (InputMismatchException e) {
                isQuitFactoring = true;
            }
        } while(!isQuitFactoring);
    }

    private static void runGridHopper() {
        System.out.println();
        Scanner input = new Scanner(System.in);

        boolean isQuitHopping = false;
        int gridSize;

        do {
            System.out.println("Enter integer to define grid square ('q' to quit)");
            try {
                gridSize = input.nextInt();
//                Random seed = new Random();
                int seed = 5;
                System.out.println("\nTARGET BOARD MAP");
                LocationPointer[][] targetBoard = BoardGenerator.createBoard(gridSize, seed);
                System.out.println("from Main");
                for(int row = 0; row < targetBoard.length; row++) {
                    for(int col = 0; col < targetBoard[row].length; col++) {
                        System.out.print("(" + targetBoard[row][col].getTargetX()+ ", " + targetBoard[row][col].getTargetY() + ") ");
                    }
                    System.out.println();
                }
                System.out.println();

//                System.out.println("BOARD AFTER HOPPING UP TO 100");
                System.out.println("BOARD AFTER ONE HOP");
                BoardHopper.hop(targetBoard);
            } catch (InputMismatchException e) {
                isQuitHopping = true;
            }
        } while(!isQuitHopping);
    }

    private static void runExpressionSolver() {
        System.out.println();
        Scanner input = new Scanner(System.in);

        boolean isQuitSolver = false;
        String expression;
        String userChoice;

        do {
            System.out.println("Enter a mathematical expression to solve ('q' to quit):");
            userChoice = input.nextLine().toLowerCase();
            isQuitSolver = (userChoice.equals("q") || userChoice.equals("quit"));
            expression = input.nextLine();
            Term result = ExpressionParser.parseExpression(expression);
            System.out.println("The result of your calculation is: " + result.getValue());
            System.out.println("\nWould you like to evaluate another expression? (y/n)");
            userChoice = input.nextLine().toLowerCase();
            isQuitSolver = userChoice.equals("n");
        } while(!isQuitSolver);
    }

    private static void printDog() {
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("            /~~~~~~~~\\                           _");
        System.out.println("    ##\\__/ @)      ~~~~~~~~\\                     \\ \\ ) )");
        System.out.println("    |              /~~\\~~~~~                ((    |  \\");
        System.out.println("     \\    /           |                          /   |");
        System.out.println("      (~~~   /         \\____________/~~~~~~~~~~~~   /");
        System.out.println("       ~~~~|~                                     /");
        System.out.println("           :                                      |");
        System.out.println("            \\                                     |");
        System.out.println("            |                               /      \\");
        System.out.println("             \\  \\_         :         \\     /~~~\\    |");
        System.out.println("             /   :~~~~~|   :~~~~~~~~~~|   :     :   :");
        System.out.println("            /    :    /    :         /    :    /    :");
        System.out.println("        (~~~     )(~~~     )     (~~~     )(~~~     )");
        System.out.println("         ~~~~~~~~  ~~~~~~~~       ~~~~~~~~  ~~~~~~~~");
        System.out.println("          STOMP     STOMP          STOMP     STOMP");
        System.out.println("");
        System.out.println("");
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}

