package com.teksystems.bootcamp.capstone2.logic.menuitems;

public enum MenuCategory {
    ENTREE("entrees"),
    SIDE("sides"),
    DRINK("drinks"),
    DESSERT("desserts"),
    THALI("thalis");

    public String fileName;

    MenuCategory(String fileName) {
        this.fileName = fileName;
    }
}
