package com.teksystems.bootcamp.capstone2.menuitems;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Dosa extends Entree implements IDosa{
    DosaType dosaType;
    private List<Side> defaultSides = new ArrayList<>();

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
