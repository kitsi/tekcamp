package com.bootcamp.teksystems.ood_exercises.facade;

import java.math.BigDecimal;

public enum Item {
    DESK(1,"Fezibo Adjustable Desk", new BigDecimal("299.99")),
    OFFICE_CHAIR(2, "Kansing Ergonomic Office Chair", new BigDecimal("209.00")),
    BOOKSHELF(3, "Ironck Bookshelf", new BigDecimal("199.99")),
    LAPTOP(4, "Macbook Pro", new BigDecimal("2199.00")),
    PENS(5, "Pilot Precise Pen, 14-Pack", new BigDecimal("20.73")),
    PAPER(6, "Oxford Filler Paper, 500 sheets", new BigDecimal("21.99"));

    public final int id;
    public final String name;
    public final BigDecimal price;

    Item(int id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
