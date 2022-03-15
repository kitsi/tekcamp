package com.teksystems.bootcamp.capstone2;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.teksystems.bootcamp.capstone2.menuitems.Dessert;

import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MenuBuilder {

    public static void menuReader() throws IOException {

        File input = new File(String.valueOf(Path.of("src/main/resources/desserts.json")));
        JsonElement fileElement = JsonParser.parseReader(new FileReader((input)));
        JsonObject fileObject = fileElement.getAsJsonObject();

        String category = fileObject.get("categoryName").getAsString();

        System.out.println("Category: " + category);
        JsonArray jsonArrayOfDesserts = fileObject.get("products").getAsJsonArray();
        List<Dessert> desserts = new ArrayList<>();
        for(JsonElement dessertElement : jsonArrayOfDesserts) {
            JsonObject dessertJsonObject = dessertElement.getAsJsonObject();
            String name = dessertJsonObject.get("name").getAsString();
            String priceString = dessertJsonObject.get("price").getAsString();
            BigDecimal price = new BigDecimal(priceString);
            Dessert dessert = new Dessert(name, price);
            desserts.add(dessert);
        }
        System.out.println("All desserts: " + desserts);
        }
}
