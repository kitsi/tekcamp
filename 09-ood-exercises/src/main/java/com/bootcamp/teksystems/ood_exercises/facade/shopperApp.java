package com.bootcamp.teksystems.ood_exercises.facade;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class shopperApp {
    public static void main(String[] args) {
        runApp();
    }

    private static void runApp() {
        Scanner input = new Scanner(System.in);
        String userChoice;

        boolean isQuit = false;

        welcome();
        do {
            Inventory inventory = new Inventory();
            displayItemMenu(inventory);
            System.out.println("What would you like to purchase? [Enter Item#]");
//            try {
                userChoice = input.nextLine().toLowerCase();
                if(userChoice.equals(Item.DESK.id)) {
                    // add to purchase
                } else if(userChoice.equals(Item.OFFICE_CHAIR.id)) {
                    // add to purchase
                } else if(userChoice.equals(Item.BOOKSHELF.id)) {
                    // add to purchase
                } else if(userChoice.equals(Item.LAPTOP.id)) {
                    // add to purchase
                } else if(userChoice.equals(Item.PENS.id)) {
                    // add to purchase
                } else if(userChoice.equals(Item.PAPER.id)) {
                    // add to purchase
                } else {
                    isQuit = quit();
                }
//            } catch (Exception e) {
//                System.out.println("Invalid selection, try again. ['q' to Quit]");
//            }

        } while(!isQuit);
    }

    private static boolean quit() {
        goodbye();
        return true;
    }

    private static void displayItemMenu(Inventory inventory) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("\n=====================================================================");
        System.out.println("                           ITEMS FOR SALE");
        System.out.println("=====================================================================");
        System.out.printf("%-7s|%-35s|%-12s|%-12s\n", " Item#", " Item", " Price", " In Stock");
        System.out.printf("%-7s|%-30s|%-12s|%-12s\n", "=======", "===================================", "============", "============");
        for(Item item : Item.values()) {
            System.out.printf(" %-6s| %-34s| %-11s| %-11s\n", item.id, item.name, formatter.format(item.price), inventory.getStock(item));
        }
        System.out.println("=====================================================================");
        System.out.println();
    }

    private static void welcome() {
        System.out.println("Welcome to Amazonia!");
    }

    private static void goodbye() {
        System.out.println("Thank you for shopping with us.");
        System.out.println("Come again soon!");
    }
}
