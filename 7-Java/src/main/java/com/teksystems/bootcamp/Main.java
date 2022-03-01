package com.teksystems.bootcamp;

import com.teksystems.bootcamp.additionalnputs.NumberAggregator;

import java.util.InputMismatchException;
import java.util.Scanner;
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
        System.out.println("Thank you for playing. Come again soon!");
        return true;
    }

    private static void runNumberAggregator() {
        System.out.println();
        Scanner input = new Scanner(System.in);
        int numberToAdd;

        boolean isQuitAggregator = false;
        int total = 0;

        do {
            System.out.println("Enter a number ('q' to quit)");
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
}

