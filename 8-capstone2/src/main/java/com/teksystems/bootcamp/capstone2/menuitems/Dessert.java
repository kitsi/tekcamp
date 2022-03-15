package com.teksystems.bootcamp.capstone2.menuitems;

import java.math.BigDecimal;

public class Dessert extends MenuItem{
    public Dessert(String name, BigDecimal price) {
        super(MenuCategory.DESSERT, name, price);
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
