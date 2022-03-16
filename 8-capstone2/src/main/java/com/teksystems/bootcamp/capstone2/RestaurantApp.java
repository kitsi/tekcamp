package com.teksystems.bootcamp.capstone2;

import com.teksystems.bootcamp.capstone2.menuitems.MenuCategory;
import com.teksystems.bootcamp.capstone2.menuitems.MenuItem;

import java.text.NumberFormat;
import java.util.*;
import java.util.List;

public class RestaurantApp {
    public static void main(String[] args) {
//        welcome();
        runApp();
    }

    private static void runApp() {
        ReceiptList receipts = createReceiptList();
        startOrder(receipts);
    }

    private static void startOrder(ReceiptList receipts) {
        Menu restaurant = new Menu();
        Map<MenuCategory, List<MenuItem>> allMenus;
        allMenus = restaurant.createMenu();

        Scanner input = new Scanner(System.in);
        String userChoice;
        boolean isQuit = false;

        Order currentOrder = createOrder(receipts);

        do {
            System.out.println("Which menu would you like to order from? ('q' to Quit)");
            System.out.println("1) Drinks\n2) Main\n3) Desserts\n");
            userChoice = input.nextLine().toLowerCase();
            if(userChoice.equals("1") || (userChoice.equals("drinks"))) {
                takeDrinkOrder(allMenus.get(MenuCategory.DRINK), currentOrder);
//            } else if(userChoice.equals("2") || (userChoice.equals("main"))) {
//                takeMainOrder(allMenus.get(MenuCategory.ENTREE), allMenus.get(MenuCategory.SIDE), allMenus.get(MenuCategory.THALI), currentOrder);
            } else if(userChoice.equals("3") || (userChoice.equals("desserts"))) {
                takeDessertOrder(allMenus.get(MenuCategory.DESSERT), currentOrder);
            } else {
                isQuit = closeOrder(currentOrder, receipts);
//                currentOrder = createOrder(receipts);
            }
        } while(!isQuit);
        boolean isNextOrder = nextOrder(receipts);
        if(isNextOrder) {
            startOrder(receipts);
        } else {
            endVisit(receipts);
        }
//        input.close();

//        isNextOrder ? startOrder(receipts) : endVisit(receipts);
//        System.out.println(currentOrder);
//        receipts.addOrderToReceiptList(currentOrder);
//        System.out.println(receipts);
    }

    private static void endVisit(ReceiptList receipts) {
        if(receipts.getOrders().size() > 1) {
            Scanner input = new Scanner(System.in);
            String userChoice;
            System.out.println("Would you like to view previous receipts?");
            userChoice = input.nextLine();
            if(userChoice.equals("y")) {
                displayPreviousReceipts(receipts);
            }
//            input.close();
        }
        System.out.println("Thank you for visiting! Come again soon!!");
    }

    private static void displayPreviousReceipts(ReceiptList receiptList) {
        for(Order order : receiptList.getOrders()) {
            displayReceipt(order);
        }
    }

    private static boolean nextOrder(ReceiptList receipts) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to place another order?");
        String userChoice2 = scanner.nextLine();
        if(userChoice2.equals("y")) {
            return true;
//            startOrder(receipts);
        } else {
            return false;
//            System.out.println("Here is the receipt for your current order");
//            displayReceipt(currentOrder, receipts);
//            endVisit(currentOrder, receipts);
        }
//        scanner.close();
    }

    private static boolean closeOrder(Order currentOrder, ReceiptList receipts) {
        Scanner input = new Scanner(System.in);
        System.out.println("Would you like to close out this order? [y/n]");
        String userChoice = input.nextLine();
        input.close();
        if(userChoice.equals("y")) {
            displayReceipt(currentOrder);
            receipts.addOrderToReceiptList(currentOrder);
            return true;
        } else {
            return false;
        }
    }

    private static void displayReceipt(Order order) {
        System.out.println(order);
//        System.out.println(receipts);
        System.out.println("Order number: " + order.getOrderNumber());
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        for(MenuItem item : order.getOrderItems()) {
            System.out.println(item.getName() + " (" + formatter.format(item.getPrice()) + ")");
        }
//        System.out.println(order);
        System.out.println("Subtotal: " + formatter.format(order.calculateSubtotal()));
        System.out.println("Tax: " + formatter.format(order.calculateTax()));
        System.out.println("Total: " + formatter.format(order.calculateTotal()));
    }

    private static ReceiptList createReceiptList() {
        ReceiptList receiptList = new ReceiptList();
        List<Order> receipts = new ArrayList<>();
        receiptList.setReceipts(receipts);
        System.out.println(receiptList);
        return receiptList;
    }

    private static Order createOrder(ReceiptList receipts) {
        Order newOrder;
        if(receipts.getOrders().equals(null)) {
            newOrder = new Order(1000);
        } else {
            newOrder = new Order(receipts.getOrders().size() + 1000);
        }
        List<MenuItem> orderItems = new ArrayList<>();
        newOrder.setOrderItems(orderItems);
        System.out.println(newOrder);
        return newOrder;
    }

//    private static void displayMenu(List menus) {
//
//    }

        private static void takeDrinkOrder(List<MenuItem> drinkMenuitems, Order currentOrder) {
            Scanner input = new Scanner(System.in);
            String userChoice;

            System.out.println("Which drink would you like to order?");
            int i = 1;
            NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
            for(MenuItem drink : drinkMenuitems) {
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
            System.out.println("drink choice in takeDrinkOrder: " + drinkChoice);
            currentOrder.addItemToOrder(drinkChoice);
            System.out.println("End of takeDrinkOrder: " + currentOrder);
//            input.close();
        }

//        private static void takeMainOrder(List<MenuItem> entrees, List<MenuItem> sides, List<MenuItem> thalis, Order currentOrder) {
//            Scanner input = new Scanner(System.in);
//            String userChoice;
//
//            System.out.println("Which main menu items would you like to order?");
//            System.out.println("ENTREES");
//            int i = 1;
//            for(MenuItem entree : entrees) {
//                NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
//                System.out.println(i + ") " + entree.getName() + " (" + formatter.format(entree.getPrice()) + ")");
//                i++;
//            }
//
//            System.out.println("SIDES");
//            for(MenuItem side : sides) {
//                NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
//                System.out.println(i + ") " + side.getName() + " (" + formatter.format(side.getPrice()) + ")");
//                i++;
//            }
//
//            System.out.println("THALIS");
//            for(MenuItem thali : thalis) {
//                System.out.println(i + ") " + thali.getName());
//                i++;
//            }
//
//            System.out.println("\nPlease make your selection:");
//            userChoice = input.nextLine().toLowerCase();
//        }

        private static void takeDessertOrder(List<MenuItem> dessertMenuitems, Order currentOrder) {
            System.out.println("Which dessert would you like to order?");
            int i = 1;
            NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
            for(MenuItem dessert : dessertMenuitems) {
                System.out.println(i + ") " + dessert.getName() + " (" + formatter.format(dessert.getPrice()) + ")");
                i++;
            }

            Scanner input = new Scanner(System.in);
            String userChoice;
            MenuItem dessertChoice = null;
            System.out.println("\nPlease make your selection:");
            userChoice = input.nextLine().toLowerCase();
//            input.close();
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
//            System.out.println(currentOrder);
        }

        private static void welcome() {
            System.out.println("Welcome to Dosa Fusion, you're in for a treat!");
            System.out.println("Here's a table with a beautiful view.");
            System.out.println("And here are the menus for you to peruse.");
        }
    }
