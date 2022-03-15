package com.teksystems.bootcamp.capstone2.menu;

import java.math.BigDecimal;

public class Entree extends MenuItem{
    public Entree(String name, BigDecimal price) {
        super(Category.ENTREE, name, price);
    }
}
