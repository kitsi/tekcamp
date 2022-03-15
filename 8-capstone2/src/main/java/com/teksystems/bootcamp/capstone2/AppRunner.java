package com.teksystems.bootcamp.capstone2;

import com.teksystems.bootcamp.capstone2.menuitems.MenuCategory;
import com.teksystems.bootcamp.capstone2.menuitems.MenuItem;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppRunner {
    public static void main(String[] args) throws IOException {
//        welcome();
        runApp();
    }

    private static void runApp() throws IOException {
        Menu restaurant = new Menu();
        Map<MenuCategory, List<MenuItem>> allMenus = new HashMap<>();
        allMenus = restaurant.createMenu();
        System.out.println(allMenus);
//        takeDrinkOrder();
//        takeEntreeOrder();
//        takeDessertOrder();
    }

    private static void takeDrinkOrder() {

    }

    private static void welcome() {
        System.out.println("Welcome to Dosa Fusion, you're in for a treat!");
        System.out.println("Here's a table with a beautiful view.");
        System.out.println("And here are the menus for you to peruse.");
    }
}
