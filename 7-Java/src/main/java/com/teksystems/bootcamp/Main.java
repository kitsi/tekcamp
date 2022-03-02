package com.teksystems.bootcamp;

import com.teksystems.bootcamp.additionalnputs.NumberAggregator;
import com.teksystems.bootcamp.findCharacters.CharFinder;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
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
            } else {
                isQuit = quit();
            }
        } while(!isQuit);
    }

    private static void displayMenu() {
        System.out.println("MENU");
        System.out.println("1. Number Aggregator");
        System.out.println("2. Find Characters");
        System.out.println("3. Factor by Two");
        System.out.println("4. Grid Hopper");
        System.out.println("5. Expression Solver");
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
            System.out.println("Enter a number ('d' for done)");
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
            System.out.println();
        } while(!isQuitFinder);
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
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

