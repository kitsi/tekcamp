package com.teksystems.bootcamp.capstone2.menuitems;

import java.math.BigDecimal;

public class Side extends MenuItem{
    public Side(String name, BigDecimal price) {
        super(MenuCategory.SIDE, name, price);
    }
}
