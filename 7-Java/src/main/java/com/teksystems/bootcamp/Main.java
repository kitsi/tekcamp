package com.teksystems.bootcamp;

import com.teksystems.bootcamp.additionalnputs.NumberAggregator;

import java.util.InputMismatchException;
import java.util.Scanner;

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
            try {
            userChoice = input.nextLine();
                if(userChoice.equals("1")) {
                    runNumberAggregator();
                } else {
                    isQuit = quit();
                }
            } catch (InputMismatchException e) {
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
        System.out.println("6. Quit");
        System.out.println("Please enter your choice: ");
    }

    private static boolean quit() {
        System.out.println("Thank you for playing. Come again soon!");
        return true;
    }

    private static void runNumberAggregator() {
        Scanner input = new Scanner(System.in);
        int numberToAdd;

        boolean isQuitAggregator = false;
        int total = 0;

        do {
            System.out.println("Please enter a number");
            try {
                numberToAdd = input.nextInt();
                total = NumberAggregator.addNumber(numberToAdd, total);
            } catch (InputMismatchException e) {
                isQuitAggregator = true;
            }
        } while(!isQuitAggregator);
        System.out.println("Your total is: " + total + "\n");
    }
}

