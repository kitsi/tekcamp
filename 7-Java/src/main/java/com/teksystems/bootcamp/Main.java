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
        NumberAggregator aggregator = new NumberAggregator();

        do {
            System.out.println("Enter an integer to aggregate ('q' to quit & get total)");
            try {
                numberToAdd = input.nextInt();
                aggregator.addNumber(numberToAdd);
            } catch (InputMismatchException e) {
                System.out.println("Invalid number - must be an integer\n");
                isQuitAggregator = true;
            }
        } while(!isQuitAggregator);
        System.out.println("Your TOTAL is: " + aggregator.getTotal() + "\n");

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ignored) {}
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
                String positions = "";
                if (entry.getValue().size() == 0) {
                    positions = "none";
                } else {
                    for (int num : entry.getValue()) {
                        positions += String.valueOf(num) + " ";
                    }
                }
                System.out.printf("%-10s | %-10s\n", "    " + entry.getKey(), positions);
            }
            System.out.println("\nWould you like to search again? (y/n)");
            userChoice = input.nextLine().toLowerCase();
            isQuitFinder = (userChoice.equals("n") || userChoice.equals("no"));
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
            System.out.println("Enter a number to factor by 2 ('q' to quit)");
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
                int seed = 4;
                LocationPointer[][] targetBoard = BoardGenerator.createBoard(gridSize, seed);
                LocationPointer finalPosition = BoardHopper.hop(targetBoard);
                System.out.println("Hopping...");
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException ignored) {}
                System.out.println("Final square position: (" + finalPosition.getTargetX() + "," + finalPosition.getTargetY() + ")\n");
            } catch (InputMismatchException e) {
                isQuitHopping = true;
            }
        } while(!isQuitHopping);
    }

    private static void runExpressionSolver() {
        System.out.println();
        Scanner input = new Scanner(System.in);

        boolean isQuitSolver = false;
        String expression = "";
        String userChoice;

        do {
            System.out.println("Enter a math" +
                    "ematical expression to solve:");
            try {
                expression = input.nextLine();
                Term result = ExpressionParser.parseExpression(expression);
                System.out.println("The result of your calculation is: " + result.getValue());
                System.out.println("\nWould you like to evaluate another expression? (y/n)");
                userChoice = input.nextLine().toLowerCase();
                isQuitSolver = (!(userChoice.equals("y") || userChoice.equals("yes")));
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Invalid expression");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ignored) {}
                isQuitSolver = true;
            }
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
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

