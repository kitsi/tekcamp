package com.teksystems.bootcamp.capstone2.logic.menuitems;

import java.math.BigDecimal;

public class MenuItem {
    MenuCategory category;
    String name;
    BigDecimal price;

    public MenuItem(MenuCategory menuCategory, String name, BigDecimal price) {
        this.category = menuCategory;
        this.name = name;
        this.price = price;
    }

    public MenuCategory getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }


}
