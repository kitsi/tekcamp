package com.teksystems.bootcamp.capstone2;

import com.teksystems.bootcamp.capstone2.logic.Order;
import com.teksystems.bootcamp.capstone2.logic.ReceiptList;
import com.teksystems.bootcamp.capstone2.logic.menuitems.DosaTopping;
import com.teksystems.bootcamp.capstone2.logic.menuitems.MenuCategory;
import com.teksystems.bootcamp.capstone2.logic.menuitems.MenuItem;

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
            } else if(userChoice.equals("2") || (userChoice.equals("main"))) {
                takeMainOrder(allMenus.get(MenuCategory.ENTREE), allMenus.get(MenuCategory.SIDE), allMenus.get(MenuCategory.THALI), currentOrder);
            } else if(userChoice.equals("3") || (userChoice.equals("desserts"))) {
                takeDessertOrder(allMenus.get(MenuCategory.DESSERT), currentOrder);
            } else {
                isQuit = closeOrder(currentOrder, receipts);
            }
        } while(!isQuit);

        boolean isNextOrder = nextOrder(receipts);
        if(isNextOrder) {
            startOrder(receipts);
        } else {
            endVisit(receipts);
        }
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
        }
        System.out.println("Thank you for visiting! Come again soon!!");
    }

    private static void displayPreviousReceipts(ReceiptList receiptList) {
        for(Order order : receiptList.getOrders()) {
            displayReceipt(order);
        }
    }

    private static boolean nextOrder(ReceiptList receipts) {
        Scanner input = new Scanner(System.in);
        String userChoice;
        System.out.println("Would you like to place another order?");
        userChoice = input.nextLine().toLowerCase();
        System.out.println(userChoice);
        if(userChoice.equals("y")) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean closeOrder(Order currentOrder, ReceiptList receipts) {
        Scanner input = new Scanner(System.in);
        System.out.println("Would you like to close out this order? [y/n]");
        String userChoice = input.nextLine();
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
        System.out.println("Order number: " + order.getOrderNumber());
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        for(MenuItem item : order.getOrderItems()) {
            System.out.println(item.getName() + " (" + formatter.format(item.getPrice()) + ")");
        }
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

    private static void takeDrinkOrder(List<MenuItem> drinkMenuItems, Order currentOrder) {
        Scanner input = new Scanner(System.in);
        String userChoice;
        MenuItem drinkChoice = null;
        System.out.println("Which drink would you like to order?");
        int i = 1;
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        for(MenuItem drink : drinkMenuItems) {
            System.out.println(i + ") " + drink.getName() + " (" + formatter.format(drink.getPrice()) + ")");
            i++;
        }

        System.out.println("\nPlease make your selection:");
        userChoice = input.nextLine().toLowerCase();
        for(MenuItem drink : drinkMenuItems) {
            if((userChoice.equals("1") || userChoice.contains("mango") || userChoice.contains("lassi")) && drink.getName().equals("Mango Lassi")) {
                System.out.println("option1 in takeDrinkOrder printing");
                drinkChoice = drink;
            } else if((userChoice.equals("2") || userChoice.contains("chai")) && (drink.getName().equals("Chai"))) {
                System.out.println("option2 in takeDrinkOrder printing");
                drinkChoice = drink;
            } else if((userChoice.equals("3") || userChoice.contains("lavender") || userChoice.contains("coconut") || userChoice.contains("lemonade")) && (drink.getName().equals("Lavender Coconut Lemonade"))) {
                System.out.println("option3 in takeDrinkOrder printing");
                drinkChoice = drink;
            } else if((userChoice.equals("4") || userChoice.contains("rose") || userChoice.contains("mint") || userChoice.contains("spritzer")) && (drink.getName().equals("Rose Mint Spritzer"))) {
                System.out.println("option4 in takeDrinkOrder printing");
                drinkChoice = drink;
            }
        }
        System.out.println("drink choice in takeDrinkOrder: " + drinkChoice);
        currentOrder.addItemToOrder(drinkChoice);
        System.out.println("End of takeDrinkOrder: " + currentOrder);
    }

//        private static void takeMainOrder(List<MenuItem> entrees, List<MenuItem> sides, List<MenuItem> thalis, Order currentOrder) {
//            Scanner input = new Scanner(System.in);
//            String userChoice;
//            NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
//
//            System.out.println("Which main menu items would you like to order?");
//            System.out.println("ENTREES");
//            int i = 1;
//            for(MenuItem entree : entrees) {
//                System.out.println(i + ") " + entree.getName() + " (" + formatter.format(entree.getPrice()) + ") ~ " + entree.getDescription());
//                i++;
//            }
//            System.out.println("OPTIONAL TOPPINGS");
//            for(DosaTopping topping : DosaTopping.values()) {
//                System.out.println(i + ") " + topping.name + " (" + formatter.format(topping.price) + ")");
//                i++;
//            }
//            System.out.println("SIDES");
//            for(MenuItem side : sides) {
//                System.out.println(i + ") " + side.getName() + " (" + formatter.format(side.getPrice()) + ")");
//                i++;
//            }
//
//            System.out.println("THALIS");
//            for(MenuItem thali : thalis) {
//                System.out.println(i + ") " + thali.getName() + " ~ " + thali.getDescription());
//                i++;
//            }
//
//            System.out.println("\nPlease make your selection:");
//            userChoice = input.nextLine().toLowerCase();
//        }

    private static void takeMainOrder(List<MenuItem> entrees, List<MenuItem> sides, List<MenuItem> thalis, Order currentOrder) {
        List<MenuItem> allMeals = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        String userChoice;
        MenuItem mealChoice = null;
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);

        System.out.println("Which main menu items would you like to order?");
        System.out.println("ENTREES");
        int i = 1;
        for (MenuItem entree : entrees) {
            System.out.println(i + ") " + entree.getName() + " (" + formatter.format(entree.getPrice()) + ") ~ " + entree.getDescription());
            i++;
            allMeals.add(entree);
        }
        System.out.println("OPTIONAL TOPPINGS");
        for (DosaTopping topping : DosaTopping.values()) {
            System.out.println(" ~ " + topping.name + " (" + formatter.format(topping.price) + ")");
//                i++;
        }
        System.out.println("SIDES");
        for (MenuItem side : sides) {
            System.out.println(" ** " + side.getName() + " (" + formatter.format(side.getPrice()) + ")");
//                i++;
        }

        System.out.println("THALIS");
        for (MenuItem thali : thalis) {
            System.out.println(i + ") " + thali.getName() + " ~ " + thali.getDescription());
            i++;
            allMeals.add(thali);
        }

        System.out.println("\nPlease make your selection:");
        userChoice = input.nextLine().toLowerCase();
        for (MenuItem meal : allMeals) {
            if (userChoice.equals("1") && meal.getName().equals("Plain Dosa")) {
                System.out.println("option1 in takeMainOrder printing");
                mealChoice = meal;
            } else if (userChoice.equals("2") && meal.getName().equals("Masala Dosa")) {
                System.out.println("option2 in takeMainOrder printing");
                mealChoice = meal;
            } else if (userChoice.equals("3") && meal.getName().equals("Gunpowder Dosa")) {
                System.out.println("option3 in takeMainOrder printing");
                mealChoice = meal;
            } else if (userChoice.equals("4") && meal.getName().equals("Idliyappam")) {
                System.out.println("option4 in takeMainOrder printing");
                mealChoice = meal;
            } else if (userChoice.equals("5") && meal.getName().equals("Double Thali")) {
                System.out.println("option5 in takeMainOrder printing");
                mealChoice = meal;
            } else if (userChoice.equals("6") && meal.getName().equals("Thali Meal")) {
                System.out.println("option5 in takeMainOrder printing");
                mealChoice = meal;
            }
        }
        System.out.println("meal choice in takeMainOrder: " + mealChoice);
        currentOrder.addItemToOrder(mealChoice);
        System.out.println("End of takeMainOrder: " + currentOrder);
    }

    private static void takeDessertOrder(List<MenuItem> dessertMenuitems, Order currentOrder) {
        Scanner input = new Scanner(System.in);
        String userChoice;
        MenuItem dessertChoice = null;
        System.out.println("Which dessert would you like to order?");
        int i = 1;
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        for(MenuItem dessert : dessertMenuitems) {
            System.out.println(i + ") " + dessert.getName() + " (" + formatter.format(dessert.getPrice()) + ")");
            i++;
        }

        System.out.println("\nPlease make your selection:");
        userChoice = input.nextLine().toLowerCase();
        for(MenuItem dessert : dessertMenuitems) {
            if((userChoice.equals("1") || userChoice.equals("chakka") || userChoice.equals("ela") || userChoice.equals("ada")) && dessert.getName().equals("Chakka Ela Ada")) {
                System.out.println("option1 in takeDessertOrder printing");
                dessertChoice = dessert;
            } else if((userChoice.equals("2") || userChoice.contains("jackfruit") || userChoice.contains("ice") || userChoice.contains("cream")) && dessert.getName().equals("Jackfruit Ice Cream")) {
                System.out.println("option2 in takeDessertOrder printing");
                dessertChoice = dessert;
            } else if((userChoice.equals("3") || userChoice.contains("beet") || userChoice.contains("halwa") || userChoice.contains("halva")) && dessert.getName().equals("Beet Halwa")) {
                System.out.println("option3 in takeDessertOrder printing");
                dessertChoice = dessert;
            } else if((userChoice.equals("4") || userChoice.contains("gulab") || userChoice.contains("jamun")) && dessert.getName().equals("Gulab Jamun (2 pieces)")) {
                System.out.println("option4 in takeDessertOrder printing");
                dessertChoice = dessert;
            } else if((userChoice.equals("5") || userChoice.contains("dates") || userChoice.contains("apple")) && dessert.getName().equals("Dates Apple Pradhaman")) {
                System.out.println("option5 in takeDessertOrder printing");
                dessertChoice = dessert;
            }
        }
        System.out.println("dessert choice in takeDessertOrder: " + dessertChoice);
        currentOrder.addItemToOrder(dessertChoice);
        System.out.println("End of takeDessertOrder: " + currentOrder);
    }

    private static void welcome() {
        System.out.println("Welcome to Dosa Fusion, you're in for a treat!");
        System.out.println("Here's a table with a beautiful view.");
        System.out.println("And here are the menus for you to peruse.");
    }
}
