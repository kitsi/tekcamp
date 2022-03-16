package com.teksystems.bootcamp.capstone2;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.teksystems.bootcamp.capstone2.menuitems.*;

import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {

    public Map<MenuCategory, List<MenuItem>> createMenu() {
        Map<MenuCategory, List<MenuItem>> allMenus = new HashMap<>();
        for(MenuCategory category : MenuCategory.values()) {
            allMenus.put(category, fileProcessor(category.fileName));
        }
        return allMenus;
    }

    public List<MenuItem> fileProcessor(String fileName) {
        List<MenuItem> menuItems = new ArrayList<>();
        try {
            File input = new File(String.valueOf(Path.of("src/main/resources/" + fileName + ".json")));
            JsonElement fileElement = JsonParser.parseReader(new FileReader(input));
            JsonObject fileObject = fileElement.getAsJsonObject();
            String category = fileObject.get("categoryName").getAsString();
            if(category.equals("desserts")) {
                menuItems = processDesserts(fileObject);
            } else if(category.equals("drinks")) {
                menuItems = processDrinks(fileObject);
            } else if(category.equals("sides")) {
                menuItems = processSides(fileObject);
            } else if(category.equals("entrees")) {
                menuItems = processEntrees(fileObject);
            } else if(category.equals("thalis")) {
                menuItems = processThalis(fileObject);
            } else {
                menuItems = null;
            }
        } catch (Exception e) {
            System.out.println("Problem processing file!");
            e.printStackTrace();
        }
        return menuItems;
    }

    private List<MenuItem> processDesserts(JsonObject fileObject) {
        JsonArray jsonArrayOfDesserts = fileObject.get("desserts").getAsJsonArray();
        List<MenuItem> desserts = new ArrayList<>();
        for (JsonElement dessertElement : jsonArrayOfDesserts) {
            JsonObject dessertJsonObject = dessertElement.getAsJsonObject();
            String name = dessertJsonObject.get("name").getAsString();
            String priceString = dessertJsonObject.get("price").getAsString();
            BigDecimal price = new BigDecimal(priceString);
            Dessert dessert = new Dessert(name, price);
            desserts.add(dessert);
        }
        return desserts;
    }

    private List<MenuItem> processDrinks(JsonObject fileObject) {
        JsonArray jsonArrayOfDrinks = fileObject.get("drinks").getAsJsonArray();
        List<MenuItem> drinks = new ArrayList<>();
        for (JsonElement drinkElement : jsonArrayOfDrinks) {
            JsonObject drinkJsonObject = drinkElement.getAsJsonObject();
            String name = drinkJsonObject.get("name").getAsString();
            String priceString = drinkJsonObject.get("price").getAsString();
            BigDecimal price = new BigDecimal(priceString);
            Drink drink = new Drink(name, price);
            drinks.add(drink);
        }
        return drinks;
    }

    private List<MenuItem> processSides(JsonObject fileObject) {
        JsonArray jsonArrayOfSides = fileObject.get("sides").getAsJsonArray();
        List<MenuItem> sides = new ArrayList<>();
        for (JsonElement sideElement : jsonArrayOfSides) {
            JsonObject sideJsonObject = sideElement.getAsJsonObject();
            String name = sideJsonObject.get("name").getAsString();
            String priceString = sideJsonObject.get("price").getAsString();
            BigDecimal price = new BigDecimal(priceString);
            Side side = new Side(name, price);
            sides.add(side);
        }
        return sides;
    }

    private List<MenuItem> processEntrees(JsonObject fileObject) {
        JsonArray jsonArrayOfEntrees = fileObject.get("entrees").getAsJsonArray();
        List<MenuItem> entrees = new ArrayList<>();
        for (JsonElement entreeElement : jsonArrayOfEntrees) {
            JsonObject entreeJsonObject = entreeElement.getAsJsonObject();
            String name = entreeJsonObject.get("name").getAsString();
            String priceString = entreeJsonObject.get("price").getAsString();
            BigDecimal price = new BigDecimal(priceString);
            Entree entree = new Entree(name, price);
            entrees.add(entree);
        }
        return entrees;
    }

    private List<MenuItem> processThalis(JsonObject fileObject) {
        JsonArray jsonArrayOfThalis = fileObject.get("thalis").getAsJsonArray();
        List<MenuItem> thalis = new ArrayList<>();
        for (JsonElement thaliElement : jsonArrayOfThalis) {
            JsonObject thaliJsonObject = thaliElement.getAsJsonObject();
            String name = thaliJsonObject.get("name").getAsString();
            if(name.equals("Thali Meal")) {
                ThaliMeal thali = new ThaliMeal(BigDecimal.ZERO);
                thalis.add(thali);
            } else if(name.equals("Double Thali")) {
                DoubleThali thali = new DoubleThali(BigDecimal.ZERO);
                thalis.add(thali);
            }
        }
        return thalis;
    }
}
