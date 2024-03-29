package com.teksystems.bootcamp.capstone2;

import com.teksystems.bootcamp.capstone2.logic.Order;
import com.teksystems.bootcamp.capstone2.logic.ReceiptList;
import com.teksystems.bootcamp.capstone2.logic.menuitems.*;

import java.text.NumberFormat;
import java.util.*;
import java.util.List;

public class RestaurantApp {
    public static void main(String[] args) {
        welcome();
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
                MenuItem drinkChosen = takeDrinkOrder(allMenus.get(MenuCategory.DRINK));
                currentOrder.addItemToOrder(drinkChosen);
            } else if(userChoice.equals("2") || (userChoice.equals("main"))) {
                MenuItem mealChosen = takeMainOrder(allMenus.get(MenuCategory.ENTREE), allMenus.get(MenuCategory.SIDE), allMenus.get(MenuCategory.THALI), allMenus.get(MenuCategory.DRINK), allMenus.get(MenuCategory.DESSERT));
                currentOrder.addItemToOrder(mealChosen);
            } else if(userChoice.equals("3") || (userChoice.equals("desserts"))) {
                MenuItem dessertChosen = takeDessertOrder(allMenus.get(MenuCategory.DESSERT));
                currentOrder.addItemToOrder(dessertChosen);
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
        return userChoice.equals("y");
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
        System.out.println("=======================");
        System.out.println("Order number: " + order.getOrderNumber());
        System.out.println("-----------------------");
        System.out.println("ITEMS ORDERED");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        for(MenuItem item : order.getOrderItems()) {
            System.out.println(item.getName() + " (" + formatter.format(item.getPrice()) + ")");
        }
        System.out.println("-----------------------");
        System.out.println("Subtotal: " + formatter.format(order.calculateSubtotal()));
        System.out.println("Tax: " + formatter.format(order.calculateTax()));
        System.out.println("Total: " + formatter.format(order.calculateTotal()));
        System.out.println("=======================\n");
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
        return newOrder;
    }

    private static MenuItem takeDrinkOrder(List<MenuItem> drinkMenuItems) {
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
                drinkChoice = drink;
            } else if((userChoice.equals("2") || userChoice.contains("chai")) && (drink.getName().equals("Chai"))) {
                drinkChoice = drink;
            } else if((userChoice.equals("3") || userChoice.contains("lavender") || userChoice.contains("coconut") || userChoice.contains("lemonade")) && (drink.getName().equals("Lavender Coconut Lemonade"))) {
                drinkChoice = drink;
            } else if((userChoice.equals("4") || userChoice.contains("rose") || userChoice.contains("mint") || userChoice.contains("spritzer")) && (drink.getName().equals("Rose Mint Spritzer"))) {
                drinkChoice = drink;
            }
        }
        return drinkChoice;
    }

    private static MenuItem takeMainOrder(List<MenuItem> entrees, List<MenuItem> sides, List<MenuItem> thalis, List<MenuItem> drinks, List<MenuItem> desserts) {
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
        for (Topping topping : Topping.values()) {
            System.out.println(" ~ " + topping.name + " (" + formatter.format(topping.price) + ")");
        }
        System.out.println("SIDES");
        for (MenuItem side : sides) {
            System.out.println(" ** " + side.getName() + " (" + formatter.format(side.getPrice()) + ")");
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
                mealChoice = meal;
                mealChoice = customizeSidesToppings(mealChoice, sides);
            } else if (userChoice.equals("2") && meal.getName().equals("Masala Dosa")) {
                mealChoice = meal;
                mealChoice = customizeSidesToppings(mealChoice, sides);
            } else if (userChoice.equals("3") && meal.getName().equals("Gunpowder Dosa")) {
                mealChoice = meal;
                mealChoice = customizeSidesToppings(mealChoice, sides);
            } else if (userChoice.equals("4") && meal.getName().equals("Idliyappam")) {
                mealChoice = meal;
                mealChoice = customizeSidesToppings(mealChoice, sides);
            } else if (userChoice.equals("5") && meal.getName().equals("Thali Meal")) {
                mealChoice = meal;
                mealChoice = addThaliItems(mealChoice, drinks, entrees, desserts, sides);
            }
        }
        return mealChoice;
    }

    private static Entree customizeSidesToppings(MenuItem entree, List<MenuItem> sides) {
        Scanner input = new Scanner(System.in);
        Entree newEntree = (Entree) entree;
        String userChoice1;
        String userChoice2;

        boolean isQuit = false;

        do {
            System.out.println("Would you like to customize Toppings? [y/n]");
            userChoice1 = input.nextLine().toLowerCase();

            if(userChoice1.equals("y")) {
                System.out.println("These are the current toppings for your meal:");
//                System.out.println("SIDE(S)");
//                for(Side side : ((Entree) entree).getSides()) {
//                    System.out.println(side.getName());
//                }
                System.out.println("TOPPING(S)");
                if(((Entree) entree).getToppings().isEmpty()) {
                    System.out.println("none");
                } else {
                    for(Topping topping : ((Entree) entree).getToppings()) {
                        System.out.println(topping.name);
                    }
                }
//                System.out.println("1) Add topping, 2) Remove topping, 3) Add Side, 4) Remove Side, 5) Quit");
                System.out.println("1) Add topping, 2) Remove topping, 3) Quit");
                userChoice2 = input.nextLine();
                if(userChoice2.equals("1")) {
                    newEntree = addTopping(entree);
                } else if(userChoice2.equals("2")) {
                    newEntree = removeTopping(entree);
//                } else if(userChoice2.equals("3")) {
//                    newEntree = addSide(entree);
//                } else if(userChoice2.equals("4")) {
////                    newEntree = removeSide(entree);
                } else {
                    isQuit = true;
                }
            } else {
                isQuit = true;
            }
        } while(!isQuit);

        return newEntree;
    }

//    private static Entree addSide(MenuItem entree) {
//        Scanner input = new Scanner(System.in);
//        String userChoice;
//        Topping sideChoice = null;
//        Entree newEntree = (Entree) entree;
//        System.out.println("What side would you like to add?");
//        int i = 1;
////        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
//        if(newEntree.getSides().size() <= Entree.MAX_SIDES) {
//            for (MenuItem side : sides) {
//                System.out.println(" ** " + side.getName() + " (" + formatter.format(side.getPrice()) + ")");
//            }
//            System.out.println("Please make your selection: ");
//            userChoice = input.nextLine().toLowerCase();
//            for(Topping topping : Topping.values()) {
//                if(userChoice.equals("1") && topping.equals(Topping.HERBED_POTATO)) {
//                    toppingChoice = topping;
//                } else if(userChoice.equals("2") && topping.equals(Topping.JACKFRUIT)) {
//                    toppingChoice = topping;
//                } else if(userChoice.equals("3") && topping.equals(Topping.PEPPER_MUSHROOM)) {
//                    toppingChoice = topping;
//                }
//            }
//            newEntree.addEntreeTopping(toppingChoice);
//        } else {
//            System.out.println("This entree already has 2 toppings.");
//        }
//        return newEntree;
//    }

    private static Entree removeTopping(MenuItem entree) {
        Scanner input = new Scanner(System.in);
        String userChoice;
        Topping toppingChoice = null;
        Entree newEntree = (Entree) entree;
        if(newEntree.getToppings().size() > 0) {
            System.out.println("What topping would you like to remove?");
            int i = 1;
//            NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
            for(Topping topping : newEntree.getToppings()) {
                System.out.println(i + ") " + topping.name);
                i++;
            }
        }
        System.out.println("Please make your selection: ");
        userChoice = input.nextLine().toLowerCase();
        for(Topping topping : Topping.values()) {
            if(userChoice.equals("1") && topping.equals(Topping.HERBED_POTATO)) {
                toppingChoice = topping;
            } else if(userChoice.equals("2") && topping.equals(Topping.JACKFRUIT)) {
                toppingChoice = topping;
            } else if(userChoice.equals("3") && topping.equals(Topping.PEPPER_MUSHROOM)) {
                toppingChoice = topping;
            }
        }
        newEntree.removeEntreeTopping(toppingChoice);
        return newEntree;
    }

    private static Entree addTopping(MenuItem entree) {
        Scanner input = new Scanner(System.in);
        String userChoice;
        Topping toppingChoice = null;
        Entree newEntree = (Entree) entree;
        System.out.println("What topping would you like to add?");
        int i = 1;
        if(newEntree.getToppings().size() <= Entree.MAX_TOPPINGS) {
            for(Topping topping : Topping.values()) {
                System.out.println(i + ") " + topping.name);
                i++;
            }
            System.out.println("Please make your selection: ");
            userChoice = input.nextLine().toLowerCase();
            for(Topping topping : Topping.values()) {
                if(userChoice.equals("1") && topping.equals(Topping.HERBED_POTATO)) {
                    toppingChoice = topping;
                } else if(userChoice.equals("2") && topping.equals(Topping.JACKFRUIT)) {
                    toppingChoice = topping;
                } else if(userChoice.equals("3") && topping.equals(Topping.PEPPER_MUSHROOM)) {
                    toppingChoice = topping;
                }
            }
            newEntree.addEntreeTopping(toppingChoice);
        } else {
            System.out.println("This entree already has 2 toppings.");
        }
        return newEntree;
    }

    private static ThaliMeal addThaliItems(MenuItem thaliMeal, List<MenuItem> drinks, List<MenuItem> entrees, List<MenuItem> desserts, List<MenuItem> sides) {
        ThaliMeal newThaliMeal = (ThaliMeal) thaliMeal;
        MenuItem drinkToAdd = takeDrinkOrder(drinks);
        newThaliMeal.addThaliItem(drinkToAdd);
        MenuItem entreeToAdd = takeMainOrder(entrees, sides);
        newThaliMeal.addThaliItem(entreeToAdd);
        MenuItem dessertToAdd = takeDessertOrder(desserts);
        newThaliMeal.addThaliItem(dessertToAdd);
        return newThaliMeal;
    }

    private static MenuItem takeMainOrder(List<MenuItem> entrees, List<MenuItem> sides) {
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
        for (Topping topping : Topping.values()) {
            System.out.println(" ~ " + topping.name + " (" + formatter.format(topping.price) + ")");
        }
        System.out.println("SIDES");
        for (MenuItem side : sides) {
            System.out.println(" ** " + side.getName() + " (" + formatter.format(side.getPrice()) + ")");
        }

        System.out.println("\nPlease make your selection:");
        userChoice = input.nextLine().toLowerCase();
        for (MenuItem meal : allMeals) {
            if (userChoice.equals("1") && meal.getName().equals("Plain Dosa")) {
                mealChoice = meal;
                mealChoice = customizeSidesToppings(mealChoice, sides);
            } else if (userChoice.equals("2") && meal.getName().equals("Masala Dosa")) {
                mealChoice = meal;
                mealChoice = customizeSidesToppings(mealChoice, sides);
            } else if (userChoice.equals("3") && meal.getName().equals("Gunpowder Dosa")) {
                mealChoice = meal;
                mealChoice = customizeSidesToppings(mealChoice, sides);
            } else if (userChoice.equals("4") && meal.getName().equals("Idliyappam")) {
                mealChoice = meal;
                mealChoice = customizeSidesToppings(mealChoice, sides);
            }
        }
        return mealChoice;
    }

    private static MenuItem takeDessertOrder(List<MenuItem> dessertMenuitems) {
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
                dessertChoice = dessert;
            } else if((userChoice.equals("2") || userChoice.contains("jackfruit") || userChoice.contains("ice") || userChoice.contains("cream")) && dessert.getName().equals("Jackfruit Ice Cream")) {
                dessertChoice = dessert;
            } else if((userChoice.equals("3") || userChoice.contains("beet") || userChoice.contains("halwa") || userChoice.contains("halva")) && dessert.getName().equals("Beet Halwa")) {
                dessertChoice = dessert;
            } else if((userChoice.equals("4") || userChoice.contains("gulab") || userChoice.contains("jamun")) && dessert.getName().equals("Gulab Jamun (2 pieces)")) {
                dessertChoice = dessert;
            } else if((userChoice.equals("5") || userChoice.contains("dates") || userChoice.contains("apple")) && dessert.getName().equals("Dates Apple Pradhaman")) {
                dessertChoice = dessert;
            }
        }
        return dessertChoice;
    }

    private static void welcome() {
        System.out.println("Welcome to Dosa Fusion, you're in for a treat!");
        System.out.println("Here's a table with a beautiful view.");
        System.out.println("And here are the menus for you to peruse.");
    }
}
