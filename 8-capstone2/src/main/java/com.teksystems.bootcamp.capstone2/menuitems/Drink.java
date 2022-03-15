package com.teksystems.bootcamp.capstone2.menuitems;

import java.math.BigDecimal;

public class Drink extends MenuItem{
    public Drink(MenuCategory category, String name, BigDecimal price) {
        super(MenuCategory.DRINK, name, price);
    }
}
