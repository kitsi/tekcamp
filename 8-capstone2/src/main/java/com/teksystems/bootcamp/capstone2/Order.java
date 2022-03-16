package com.teksystems.bootcamp.capstone2;

import com.teksystems.bootcamp.capstone2.menuitems.MenuItem;

import java.math.BigDecimal;
import java.util.List;

public class Order {
    private int orderNumber;
    private List<MenuItem> orderItems;
    private static final BigDecimal taxPercent = new BigDecimal("0.08");
    private BigDecimal subtotal;
    private BigDecimal tax;
    private BigDecimal total;

    public Order(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public List<MenuItem> getOrderItems() {
        return orderItems;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public List<MenuItem> getMenuItems() {
        return orderItems;
    }

    public List<MenuItem> addItemToOrder(MenuItem itemToAdd) {
        orderItems.add(itemToAdd);
        calculateSubtotal();
        calculateTax();
        calculateTotal();
        System.out.println(orderItems);
        return orderItems;
    }

    public void setOrderItems(List<MenuItem> orderItems) {
        this.orderItems = orderItems;
    }

    public BigDecimal calculateSubtotal() {
        subtotal = BigDecimal.ZERO;
        for(MenuItem item : orderItems) {
            subtotal = subtotal.add(item.getPrice());
        }
        return subtotal;
    }

    public BigDecimal calculateTax() {
        tax =  subtotal.multiply(taxPercent);
        return tax;
    }

    public BigDecimal calculateTotal() {
        total = subtotal.add(tax);
        return total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", orderItems=" + orderItems +
                ", subtotal=" + subtotal +
                ", tax=" + tax +
                ", total=" + total +
                '}';
    }
}
