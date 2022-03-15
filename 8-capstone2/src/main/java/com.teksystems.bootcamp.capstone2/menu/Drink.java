package com.teksystems.bootcamp.capstone2.menu;

import java.math.BigDecimal;

public class Drink extends MenuItem{
    public Drink(Category category, String name, BigDecimal price) {
        super(Category.DRINK, name, price);
    }
}
