package com.teksystems.bootcamp.capstone2.logic.menuitems;

import java.math.BigDecimal;

public enum Topping {
    HERBED_POTATO("Herbed Potato", BigDecimal.ONE),
    JACKFRUIT("Jackfruit", BigDecimal.valueOf(2)),
    PEPPER_MUSHROOM("Pepper Mushroom", BigDecimal.valueOf(2));

    public String name;
    public BigDecimal price;

    Topping(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }
}
