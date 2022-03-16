package com.teksystems.bootcamp.capstone2.logic.menuitems;

import java.math.BigDecimal;

public class Drink extends MenuItem{
    public Drink(String name, BigDecimal price) {
        super(MenuCategory.DRINK, name, price);
    }

    @Override
    public String toString() {
        return "Drink{" +
                "category=" + category +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
