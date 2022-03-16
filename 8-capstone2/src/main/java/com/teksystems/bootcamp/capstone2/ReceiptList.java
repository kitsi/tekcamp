package com.teksystems.bootcamp.capstone2;

import com.teksystems.bootcamp.capstone2.menuitems.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class ReceiptList {
    private List<Order> receipts;

    public List<Order> getOrders() {
        return receipts;
    }

    public void setReceipts(List<Order> receipts) {
        this.receipts = receipts;
    }

    public List<Order> addOrderToReceiptList(Order orderToAdd) {
        receipts.add(orderToAdd);
        return receipts;
    }

    @Override
    public String toString() {
        return "ReceiptList{" +
                "receipts=" + receipts +
                '}';
    }
}
