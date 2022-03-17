package com.teksystems.bootcamp.capstone2.logic.menuitems;

import java.math.BigDecimal;

public class Entree extends MenuItem{

    public Entree(String name, BigDecimal price, String description) {
        super(MenuCategory.ENTREE, name, price, description);
    }

    //    @Override
//    public String toString() {
//        return "Entree{" +
////                "sides=" + sides +
//                ", category=" + category +
//                ", name='" + name + '\'' +
//                ", price=" + price +
//                '}';
//    }


    @Override
    public String toString() {
        return "Entree{" +
                "description='" + description + '\'' +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
