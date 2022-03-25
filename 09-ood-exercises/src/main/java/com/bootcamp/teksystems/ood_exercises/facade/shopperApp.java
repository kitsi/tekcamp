package com.bootcamp.teksystems.ood_exercises.facade;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class shopperApp {
    public static void main(String[] args) {
        runApp();
    }

    private static void runApp() {
        PurchaseFacade facade = new PurchaseFacade();
        Scanner input = new Scanner(System.in);
        int itemId;
        int quantity = 0;

        boolean isQuit = false;

        welcome();
        do {
            displayItemMenu(facade);
            try {
                System.out.println("What would you like to purchase? [Enter Item# or 'q' to Quit]");
                itemId = input.nextInt();
                if(itemId > 0 || itemId < 7) {
                    System.out.println("How many? [Enter quantity]");
                    quantity = input.nextInt();
                } else {
                    isQuit = quit(facade);
                }
                if(facade.processOrderItem(itemId, quantity)) {
                    System.out.println("Item added to order");
                } else {
                    System.out.println("Unable to add item to order");
                }
            } catch (Exception e) {
//                System.out.println("Invalid selection.");
                isQuit = quit(facade);
            }
        } while(!isQuit);
    }

    private static boolean quit(PurchaseFacade facade) {
        Scanner input = new Scanner(System.in);
        String userChoice;
        System.out.println("Would you like to end this transaction? [y/n]");
        userChoice = input.nextLine().toLowerCase();
        if(userChoice.equals("n")) {
            return false;
        } else if(!facade.isOrderEmpty()) {
            completePurchase(facade);
            return true;
        } else {
            goodbye();
            return true;
        }
    }

    private static void completePurchase(PurchaseFacade facade) {
        Scanner input = new Scanner(System.in);
        int userChoice;
        printInvoice(facade);
        try {
            System.out.println("How would you like to pay?");
            System.out.println(facade.getPaymentOptions());
            userChoice = input.nextInt();
            if(userChoice > 0 && userChoice < 4) {
                System.out.println(facade.processPayment(userChoice));
            } else {

            };
        } catch (Exception e) {
            System.out.println("Invalid choice, try again");
        }
    }

    private static void printInvoice(PurchaseFacade facade) {
        System.out.println(facade.getInvoice());
    }

    private static void displayItemMenu(PurchaseFacade facade) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("\n=====================================================================");
        System.out.println("                           ITEMS FOR SALE");
        System.out.println("=====================================================================");
        System.out.printf("%-7s|%-35s|%-12s|%-12s\n", " Item#", " Item", " Price", " In Stock");
        System.out.printf("%-7s|%-30s|%-12s|%-12s\n", "=======", "===================================", "============", "============");
        for(Item item : Item.values()) {
            System.out.printf(" %-6s| %-34s| %-11s| %-11s\n", item.id, item.name, formatter.format(item.price), facade.getStock(item));
        }
        System.out.println("=====================================================================");
        System.out.println();
    }

    private static void welcome() {
        System.out.println("Welcome to Amazonia!");
    }

    private static void goodbye() {
        System.out.println("Thank you for stopping by!");
        System.out.println("Please come again soon!!");
    }
}
