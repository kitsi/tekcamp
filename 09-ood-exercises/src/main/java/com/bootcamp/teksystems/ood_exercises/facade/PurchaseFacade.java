package com.bootcamp.teksystems.ood_exercises.facade;

import java.util.List;
import java.util.Map;

public class PurchaseFacade {
    private final Inventory inventory = new Inventory();
    private final Order order = new Order();
    private final Billing billing = new Billing();

    public boolean processOrderItem(int itemId, int quantity) {
        boolean isPurchased = false;
        Item itemToPurchase = null;
        for(Item item : Item.values()) {
            if(itemId == item.id) {
                itemToPurchase = item;
            }
        }
        if(inventory.inStock(itemToPurchase, quantity)) {
            inventory.removeFromInventory(itemToPurchase, quantity);
            order.addToOrder(itemToPurchase, quantity);
            isPurchased = true;
        }
        return isPurchased;
    }

    public int getStock(Item item) {
        return inventory.getStock(item);
    }

    public boolean isOrderEmpty() {
        return order.getOrder().isEmpty();
    }

    public void emptyOrder() {
        order.emptyOrder();
        inventory.replenishInventory();
    }

    public void replenishInventory() {
        inventory.replenishInventory();
    }

    public String getPaymentOptions() {
        return Payment.getPaymentOptions();
    }

    public List<String> getInvoice() {
        return billing.createInvoice(order);
    }

    public String processPayment(int paymentChoice) {
        if(!isOrderEmpty()) {
            return Payment.processPayment(paymentChoice);
        } else {
            return Payment.processPayment(-1);
        }
    }

    public List<String> ship(String name, String streetAddress, String city, String state, String zip) {
        if(!isOrderEmpty()) {
            return Shipping.processShipping(name, streetAddress, city, state, zip);
        } else {
            return Shipping.processShipping("", "", "", "", "");
        }
    }
}
