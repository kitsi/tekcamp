package com.teksystems.bootcamp.capstone2.logic.menuitems;

import java.math.BigDecimal;

public class Entree extends MenuItem{

//    private List<Side> sides = new ArrayList<>();

    public Entree(String name, BigDecimal price) {
        super(MenuCategory.ENTREE, name, price);
    }

    @Override
    public String toString() {
        return "Entree{" +
//                "sides=" + sides +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
