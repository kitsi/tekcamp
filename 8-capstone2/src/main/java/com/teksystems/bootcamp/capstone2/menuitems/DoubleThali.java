package com.teksystems.bootcamp.capstone2.menuitems;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DoubleThali extends MenuItem implements IThali{

    private List<MenuItem> thaliItems = new ArrayList<>();

    public DoubleThali(BigDecimal price) {
        super(MenuCategory.THALI, "Double Thali", price);
        this.thaliItems = thaliItems;
        this.price = calculateThaliPrice();
    }

    @Override
    public List getThaliItems() {
        return thaliItems;
    }

    @Override
    public BigDecimal calculateThaliPrice() {
        BigDecimal sumItemPrices = BigDecimal.ZERO;
        for(MenuItem item : thaliItems) {
            sumItemPrices = sumItemPrices.add(item.getPrice());
        }
        return sumItemPrices.multiply(DISCOUNTED_PERCENT);
    }

    public void addThaliItem(MenuItem thaliItem) {
        thaliItems.add(thaliItem);
    }

    @Override
    public String toString() {
        return "DoubleThali{" +
                "thaliItems=" + thaliItems +
                '}';
    }
}
