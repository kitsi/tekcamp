package com.bootcamp.teksystems.ood_exercises.factories;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Northpole {
    public static Map<String, ChildCategory> createSantaList() {
        Map<String, ChildCategory> childList = new HashMap<>();
        try{
            File input = new File(String.valueOf(Path.of("src/main/resources/santaList.json")));
            JsonElement fileElement = JsonParser.parseReader(new FileReader((input)));
            JsonObject fileObject = fileElement.getAsJsonObject();
            JsonArray santaList = fileObject.get("santaList").getAsJsonArray();
            System.out.println(santaList);


        } catch (Exception e) {
            System.out.println("Problem processing json file!");
            e.printStackTrace();
        }
        return childList;
    }
}
