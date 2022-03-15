package com.teksystems.bootcamp.capstone2.menu;

import java.math.BigDecimal;

public class MenuItem {
    Category category;
    String name;
    BigDecimal price;

    public MenuItem(Category category, String name, BigDecimal price) {
        this.category = category;
        this.name = name;
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
