package com.teksystems.bootcamp.capstone2.menuitems;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
