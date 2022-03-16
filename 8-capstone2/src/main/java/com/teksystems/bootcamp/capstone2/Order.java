package com.teksystems.bootcamp.capstone2;

import com.teksystems.bootcamp.capstone2.menuitems.MenuItem;

import java.util.List;

public class Order {
    private int orderNumber;
    private List<MenuItem> orderItems;

    public Order(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public List<MenuItem> getMenuItems() {
        return orderItems;
    }

    public List<MenuItem> addItemToOrder(MenuItem itemToAdd) {
        orderItems.add(itemToAdd);
        return orderItems;
    }
}
