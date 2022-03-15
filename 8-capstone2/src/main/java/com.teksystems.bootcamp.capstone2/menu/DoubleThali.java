package com.teksystems.bootcamp.capstone2.menu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DoubleThali implements IThali{

    private List<MenuItem> thaliItems = new ArrayList<>();
    private final BigDecimal DISCOUNTED_PERCENT = BigDecimal.valueOf(0.80);

    @Override
    public List getThaliItems() {
        return thaliItems;
    }

    public void addThaliItem(MenuItem thaliItem) {
        thaliItems.add(thaliItem);
    }

    public BigDecimal getPrice() {
        BigDecimal sumItemPrices = BigDecimal.ZERO;
        for(MenuItem item : thaliItems) {
            sumItemPrices = sumItemPrices.add(item.getPrice());
        }
        return sumItemPrices.multiply(DISCOUNTED_PERCENT);
    }
}
