package com.teksystems.bootcamp.capstone2.menu;

import java.math.BigDecimal;

public class Side extends MenuItem{
    public Side(Category category, String name, BigDecimal price) {
        super(Category.SIDE, name, price);
    }
}
