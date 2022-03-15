package com.teksystems.bootcamp.capstone2.menuitems;

import java.math.BigDecimal;

public enum DosaType {
    PLAIN(BigDecimal.ZERO),
    BUTTER(BigDecimal.ZERO),
    MYSORE(BigDecimal.valueOf(1)),
    HYDERABAD(BigDecimal.valueOf(1));

    public final BigDecimal price;

    private DosaType(BigDecimal price) {
        this.price = price;
    }
}
