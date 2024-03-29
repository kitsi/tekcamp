package com.teksystems.bootcamp.capstone2.logic.menuitems;

import java.math.BigDecimal;

public class Dessert extends MenuItem{
    public Dessert(String name, BigDecimal price) {
        super(MenuCategory.DESSERT, name, "");
        this.price = price;
    }

    @Override
    public String toString() {
        return "Dessert{" +
                "category=" + category +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
