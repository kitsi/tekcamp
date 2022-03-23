package com.teksystems.bootcamp.capstone2.logic.menuitems;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ThaliMeal extends MenuItem implements IThali{
    private List<MenuItem> thaliItems = new ArrayList<>();

    public ThaliMeal(String description) {
        super(MenuCategory.THALI, "Thali Meal", description);
    }

    @Override
    public BigDecimal getPrice() {
        return calculateThaliPrice();
    }

    @Override
    public BigDecimal calculateThaliPrice() {
        BigDecimal sumItemPrices = BigDecimal.ZERO;
        for(MenuItem item : thaliItems) {
            sumItemPrices = sumItemPrices.add(item.getPrice());
        }
        price =  sumItemPrices.multiply(DISCOUNTED_PERCENT);
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void addThaliItem(MenuItem thaliItem) {
        thaliItems.add(thaliItem);
    }

    @Override
    public List getThaliItems() {
        return thaliItems;
    }


    @Override
    public String toString() {
        return "ThaliMeal{" +
                "thaliItems=" + thaliItems +
                ", price=" + price +
                '}';
    }
}
