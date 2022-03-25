package com.bootcamp.teksystems.ood_exercises.facade;

import java.util.HashMap;
import java.util.Map;

public class Order {
    Map<Item, Integer> order = new HashMap<>();

    public Map<Item, Integer> getOrder() {
        return order;
    }

    public void addToOrder(Item item, int quantity) {
        order.put(item, quantity);
    }
}
