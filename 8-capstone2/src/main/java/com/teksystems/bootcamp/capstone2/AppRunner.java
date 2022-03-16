package com.teksystems.bootcamp.capstone2;

import com.teksystems.bootcamp.capstone2.menuitems.MenuCategory;
import com.teksystems.bootcamp.capstone2.menuitems.MenuItem;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.*;

public class AppRunner {
    public static void main(String[] args) {
//        welcome();
        runApp();
    }

    private static void runApp() {
        Menu restaurant = new Menu();
        Map<MenuCategory, List<MenuItem>> allMenus;
        allMenus = restaurant.createMenu();

        Scanner input = new Scanner(System.in);
        String userChoice;
        boolean isQuit = false;

        do {
            System.out.println("Which menu would you like to order from? ('q' to Quit");
            System.out.println("1) Drinks\n2) Main\n3) Desserts\n");
            userChoice = input.nextLine().toLowerCase();
            if(userChoice.equals("1") || (userChoice.equals("drinks"))) {
                takeDrinkOrder(allMenus.get(MenuCategory.DRINK));
            } else if(userChoice.equals("2") || (userChoice.equals("main"))) {
                takeMainOrder(allMenus.get(MenuCategory.ENTREE), allMenus.get(MenuCategory.SIDE), allMenus.get(MenuCategory.THALI));
            } else if(userChoice.equals("3") || (userChoice.equals("desserts"))) {
                takeDessertOrder(allMenus.get(MenuCategory.DESSERT));
            } else {
//                isQuit = displayReceipt();
                isQuit = true;
            }
        } while(!isQuit);
    }

//    private static void displayMenu(List menus) {
//
//    }

    private static void takeDrinkOrder(List<MenuItem> drinkMenuitems) {
        Scanner input = new Scanner(System.in);
        String userChoice;

        System.out.println("Which drink would you like to order?");
        int i = 1;
        for(MenuItem drink : drinkMenuitems) {
            NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
            System.out.println(i + ") " + drink.getName() + " (" + formatter.format(drink.getPrice()) + ")");
            i++;
        }
        System.out.println("\nPlease make your selection:");
        userChoice = input.nextLine().toLowerCase();
    }

    private static void takeMainOrder(List<MenuItem> entrees, List<MenuItem> sides, List<MenuItem> thalis) {
        Scanner input = new Scanner(System.in);
        String userChoice;

        System.out.println("Which main menu items would you like to order?");
        System.out.println("ENTREES");
        int i = 1;
        for(MenuItem entree : entrees) {
            NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
            System.out.println(i + ") " + entree.getName() + " (" + formatter.format(entree.getPrice()) + ")");
            i++;
        }

        System.out.println("SIDES");
        for(MenuItem side : sides) {
            NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
            System.out.println(i + ") " + side.getName() + " (" + formatter.format(side.getPrice()) + ")");
            i++;
        }

        System.out.println("THALIS");
        for(MenuItem thali : thalis) {
            System.out.println(i + ") " + thali.getName());
            i++;
        }

        System.out.println("\nPlease make your selection:");
        userChoice = input.nextLine().toLowerCase();
    }

    private static void takeDessertOrder(List<MenuItem> dessertMenuitems) {
        Scanner input = new Scanner(System.in);
        String userChoice;

        System.out.println("Which dessert would you like to order?");
        int i = 1;
        for(MenuItem dessert : dessertMenuitems) {
            NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
            System.out.println(i + ") " + dessert.getName() + " (" + formatter.format(dessert.getPrice()) + ")");
            i++;
        }
        System.out.println("\nPlease make your selection:");
        userChoice = input.nextLine().toLowerCase();
    }

    private static void welcome() {
        System.out.println("Welcome to Dosa Fusion, you're in for a treat!");
        System.out.println("Here's a table with a beautiful view.");
        System.out.println("And here are the menus for you to peruse.");
    }
}
