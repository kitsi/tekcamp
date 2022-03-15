package com.teksystems.bootcamp.capstone2.menuitems;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ThaliMeal implements IThali{
    private List<MenuItem> thaliItems = new ArrayList<>();
    private BigDecimal price;

    public ThaliMeal() {
        this.thaliItems = thaliItems;
        this.price = calculateThaliPrice();
    }

    @Override
    public List getThaliItems() {
        return thaliItems;
    }

    public void addThaliItem(MenuItem thaliItem) {
        thaliItems.add(thaliItem);
    }

    @Override
    public BigDecimal calculateThaliPrice() {
        BigDecimal sumItemPrices = BigDecimal.ZERO;
        for(MenuItem item : thaliItems) {
            sumItemPrices = sumItemPrices.add(item.getPrice());
        }
        return sumItemPrices.multiply(DISCOUNTED_PERCENT);
    }

    @Override
    public String toString() {
        return "ThaliMeal{" +
                "thaliItems=" + thaliItems +
                ", price=" + price +
                '}';
    }
}
