package com.teksystems.bootcamp.capstone2.logic.menuitems;

import java.math.BigDecimal;

public enum DosaType {
    PLAIN(BigDecimal.ZERO),
    BUTTER(BigDecimal.ZERO),
    MYSORE(BigDecimal.valueOf(1)),
    HYDERABAD(BigDecimal.valueOf(1));

    public BigDecimal price;

    DosaType(BigDecimal price) {
        this.price = price;
    }
}
