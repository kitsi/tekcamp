package com.teksystems.bootcamp.capstone2;

import com.google.gson.*;
import com.teksystems.bootcamp.capstone2.menuitems.Dessert;
import com.teksystems.bootcamp.capstone2.menuitems.Drink;
import com.teksystems.bootcamp.capstone2.menuitems.Entree;
import com.teksystems.bootcamp.capstone2.menuitems.Side;

import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MenuBuilder {

    public static void menuReader() throws IOException {
        String[] categoryFiles = {"drinks", "sides", "desserts", "entrees", "thalis"};

        for (String file : categoryFiles) {
            File input = new File(String.valueOf(Path.of("src/main/resources/" + file + ".json")));
            JsonElement fileElement = JsonParser.parseReader(new FileReader(input));
            JsonObject fileObject = fileElement.getAsJsonObject();
            String category = fileObject.get("categoryName").getAsString();
            if(category.equals("desserts")) {
                processDesserts(fileObject);
            } else if(category.equals("drinks")) {
                processDrinks(fileObject);
            } else if(category.equals("sides")) {
                processSides(fileObject);
            } else {
                System.out.println("nothing yet for " + category);
            }
        }
    }

    private static void processDesserts(JsonObject fileObject) {
        JsonArray jsonArrayOfDesserts = fileObject.get("desserts").getAsJsonArray();
        List<Dessert> desserts = new ArrayList<>();
        for (JsonElement dessertElement : jsonArrayOfDesserts) {
            JsonObject dessertJsonObject = dessertElement.getAsJsonObject();
            String name = dessertJsonObject.get("name").getAsString();
            String priceString = dessertJsonObject.get("price").getAsString();
            BigDecimal price = new BigDecimal(priceString);
            Dessert dessert = new Dessert(name, price);
            desserts.add(dessert);
        }
        System.out.println("All desserts: " + desserts);
    }

    private static void processDrinks(JsonObject fileObject) {
        JsonArray jsonArrayOfDrinks = fileObject.get("drinks").getAsJsonArray();
        List<Drink> drinks = new ArrayList<>();
        for (JsonElement drinkElement : jsonArrayOfDrinks) {
            JsonObject drinkJsonObject = drinkElement.getAsJsonObject();
            String name = drinkJsonObject.get("name").getAsString();
            String priceString = drinkJsonObject.get("price").getAsString();
            BigDecimal price = new BigDecimal(priceString);
            Drink drink = new Drink(name, price);
            drinks.add(drink);
        }
        System.out.println("All drinks: " + drinks);
    }

    private static void processSides(JsonObject fileObject) {
        JsonArray jsonArrayOfSides = fileObject.get("sides").getAsJsonArray();
        List<Side> sides = new ArrayList<>();
        for (JsonElement sideElement : jsonArrayOfSides) {
            JsonObject sideJsonObject = sideElement.getAsJsonObject();
            String name = sideJsonObject.get("name").getAsString();
            String priceString = sideJsonObject.get("price").getAsString();
            BigDecimal price = new BigDecimal(priceString);
            Side side = new Side(name, price);
            sides.add(side);
        }
        System.out.println("All sides: " + sides);
    }

    private static void processEntrees(JsonObject fileObject) {
//        JsonArray jsonArrayOfEntrees = fileObject.get("sides").getAsJsonArray();
//        List<Entree> entrees = new ArrayList<>();
//        for (JsonElement entreeElement : jsonArrayOfEntrees) {
//            JsonObject entreeJsonObject = entreeElement.getAsJsonObject();
//            String name = entreeJsonObject.get("name").getAsString();
//            String priceString = entreeJsonObject.get("price").getAsString();
//            BigDecimal price = new BigDecimal(priceString);
//            Entree entree = new Entree(name, price);
//            sides.add(side);
//        }
//        System.out.println("All sides: " + sides);
    }

    private static void processThalis() {
        //
    }

}
