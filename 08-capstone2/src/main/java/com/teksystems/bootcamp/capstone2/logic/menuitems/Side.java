package com.teksystems.bootcamp.capstone2.logic.menuitems;

import java.math.BigDecimal;

public class Side extends MenuItem{
    public Side(String name, BigDecimal price) {
        super(MenuCategory.SIDE, name, "");
        this.price = price;
    }
}
