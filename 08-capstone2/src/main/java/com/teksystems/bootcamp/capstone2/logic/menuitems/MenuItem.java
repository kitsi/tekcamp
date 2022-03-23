package com.teksystems.bootcamp.capstone2.logic.menuitems;

import java.math.BigDecimal;

public class MenuItem {
    MenuCategory category;
    String name;
    BigDecimal price;
    String description;

    public MenuItem(MenuCategory menuCategory, String name, String description) {
        this.category = menuCategory;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }
}
