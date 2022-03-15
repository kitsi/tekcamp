package com.teksystems.bootcamp.capstone2.menu;

import java.math.BigDecimal;

public class Dosa extends Entree implements IDosa{
    DosaType dosaType;

    public Dosa(String name, BigDecimal price) {
        this(name, price, DosaType.PLAIN);
    }

    public Dosa(String name, BigDecimal price, DosaType dosaType) {
        super(name, price);
        this.dosaType = dosaType;
    }

    @Override
    public DosaType getType() {
        return dosaType;
    }
}
