package com.teksystems.bootcamp.capstone2;

import com.teksystems.bootcamp.capstone2.menuitems.Drink;
import com.teksystems.bootcamp.capstone2.menuitems.MenuCategory;
import com.teksystems.bootcamp.capstone2.menuitems.MenuItem;

import java.awt.*;
import java.text.NumberFormat;
import java.util.*;
import java.util.List;

public class RestaurantApp {
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

        ReceiptList receipts = createReceiptList();
        Order currentOrder = createOrder(receipts);

        do {
            System.out.println("Which menu would you like to order from? ('q' to Quit");
            System.out.println("1) Drinks\n2) Main\n3) Desserts\n");
            userChoice = input.nextLine().toLowerCase();
            if(userChoice.equals("1") || (userChoice.equals("drinks"))) {
                takeDrinkOrder(allMenus.get(MenuCategory.DRINK), currentOrder);
            } else if(userChoice.equals("2") || (userChoice.equals("main"))) {
                takeMainOrder(allMenus.get(MenuCategory.ENTREE), allMenus.get(MenuCategory.SIDE), allMenus.get(MenuCategory.THALI), currentOrder);
            } else if(userChoice.equals("3") || (userChoice.equals("desserts"))) {
                takeDessertOrder(allMenus.get(MenuCategory.DESSERT), currentOrder);
            } else {
//                isQuit = displayReceipt();
                isQuit = true;
            }
        } while(!isQuit);
    }

    private static ReceiptList createReceiptList() {
        ReceiptList receiptList = new ReceiptList();
        List<Order> receipts = new ArrayList<>();
        receiptList.setReceipts(receipts);
        return receiptList;
    }

    private static Order createOrder(ReceiptList receipts) {
        Order newOrder;
        if(receipts.getReceipts().equals(null)) {
            newOrder = new Order(1000);
        } else {
            newOrder = new Order(receipts.getReceipts().size() + 1000);
        }
        List<MenuItem> orderItems = new ArrayList<>();
        newOrder.setOrderItems(orderItems);
        return newOrder;
    }


//    private static void closeOrder(Order order, ReceiptList receipts) {
//        receipts.addOrderToReceiptList(order);
//    }

//    private static void displayMenu(List menus) {
//
//    }

        private static void takeDrinkOrder(List<MenuItem> drinkMenuitems, Order currentOrder) {
            Scanner input = new Scanner(System.in);
            String userChoice;

            System.out.println("Which drink would you like to order?");
            int i = 1;
            for(MenuItem drink : drinkMenuitems) {
                NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
                System.out.println(i + ") " + drink.getName() + " (" + formatter.format(drink.getPrice()) + ")");
                i++;
            }

            MenuItem drinkChoice = null;
            System.out.println("\nPlease make your selection:");
            userChoice = input.nextLine().toLowerCase();
            for(MenuItem drink : drinkMenuitems) {
                if(userChoice.equals("1") || userChoice.contains("mango") || userChoice.contains("lassi") && drink.getName().equals("Mango Lassi")) {
                    drinkChoice = drink;
                } else if(userChoice.equals("2") || userChoice.contains("chai") && drink.getName().equals("Chai")) {
                    drinkChoice = drink;
                } else if(userChoice.equals("3") || userChoice.contains("lavender") || userChoice.contains("coconut") || userChoice.contains("lemonade") && drink.getName().equals("Lavender Coconut Lemonade")) {
                    drinkChoice = drink;
                } else if(userChoice.equals("4") || userChoice.contains("rose") || userChoice.contains("mint") || userChoice.contains("spritzer") && drink.getName().equals("Rose Mint Spritzer")) {
                    drinkChoice = drink;
                } else {
                    break;
                }
            }
            currentOrder.addItemToOrder(drinkChoice);
        }

        private static void takeMainOrder(List<MenuItem> entrees, List<MenuItem> sides, List<MenuItem> thalis, Order currentOrder) {
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

        private static void takeDessertOrder(List<MenuItem> dessertMenuitems, Order currentOrder) {
            Scanner input = new Scanner(System.in);
            String userChoice;

            System.out.println("Which dessert would you like to order?");
            int i = 1;
            for(MenuItem dessert : dessertMenuitems) {
                NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
                System.out.println(i + ") " + dessert.getName() + " (" + formatter.format(dessert.getPrice()) + ")");
                i++;
            }

            MenuItem dessertChoice = null;
            System.out.println("\nPlease make your selection:");
            userChoice = input.nextLine().toLowerCase();
            for(MenuItem dessert : dessertMenuitems) {
                if(userChoice.equals("1") || userChoice.equals("chakka") || userChoice.equals("ela") || userChoice.equals("ada") && dessert.getName().equals("Chakka Ela Ada")) {
                    dessertChoice = dessert;
                } else if(userChoice.equals("2") || userChoice.contains("jackfruit") || userChoice.contains("ice") || userChoice.contains("cream") && dessert.getName().equals("Jackfruit Ice Cream")) {
                    dessertChoice = dessert;
                } else if(userChoice.equals("3") || userChoice.contains("beet") || userChoice.contains("halwa") || userChoice.contains("halva") && dessert.getName().equals("Beet Halwa")) {
                    dessertChoice = dessert;
                } else if(userChoice.equals("4") || userChoice.contains("gulab") || userChoice.contains("jamun") && dessert.getName().equals("Gulab Jamun")) {
                    dessertChoice = dessert;
                } else {
                    break;
                }
            }
            currentOrder.addItemToOrder(dessertChoice);
        }

        private static void welcome() {
            System.out.println("Welcome to Dosa Fusion, you're in for a treat!");
            System.out.println("Here's a table with a beautiful view.");
            System.out.println("And here are the menus for you to peruse.");
        }
    }
