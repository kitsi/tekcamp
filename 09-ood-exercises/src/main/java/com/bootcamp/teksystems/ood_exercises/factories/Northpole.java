package com.bootcamp.teksystems.ood_exercises.factories;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Northpole {
    public static Map<ChildCategory, List<String>> createSantaMap() {
        Map<ChildCategory, List<String>> childMap = new HashMap<>();

        try{
            File input = new File(String.valueOf(Path.of("src/main/resources/santaList.json")));
            JsonElement fileElement = JsonParser.parseReader(new FileReader((input)));
            JsonObject fileObject = fileElement.getAsJsonObject();
            JsonArray santaList = fileObject.get("santaList").getAsJsonArray();
            for(ChildCategory childCategory : ChildCategory.values()) {
                childMap.put(childCategory, processJsonList(childCategory, santaList));
            }
        } catch (Exception e) {
            System.out.println("Problem processing json file!");
            e.printStackTrace();
        }
        return childMap;
    }

    private static List<String> processJsonList(ChildCategory childCategory, JsonArray santaList) {
        List<String> childNames = new ArrayList<>();
        for(JsonElement listElement : santaList) {
            JsonObject listObject = listElement.getAsJsonObject();
            String category = listObject.get("categoryName").getAsString();
            if(childCategory.toString().toLowerCase().equals(category)) {
                childNames = processChildNamesPerCategory(listObject);
            }
        }
        return childNames;
    }

    private static List<String> processChildNamesPerCategory(JsonObject jsonObject) {
        JsonArray jsonArrayOfChildNames = jsonObject.get("childNames").getAsJsonArray();
        List<String> childNames = new ArrayList<>();
        for(JsonElement nameElement : jsonArrayOfChildNames) {
            String childName = nameElement.getAsString();
            childNames.add(childName);
        }
        return childNames;
    }
}
