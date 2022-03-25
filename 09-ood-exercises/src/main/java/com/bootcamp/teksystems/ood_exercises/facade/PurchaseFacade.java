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

    public List<String> getInvoice() {
        return billing.createInvoice(order);
    }

    public int getStock(Item item) {
        return inventory.getStock(item);
    }

    public boolean isOrderEmpty() {
        return order.getOrder().isEmpty();
    }

    public String getPaymentOptions() {
        return Payment.getPaymentOptions();
    }

    public String processPayment(int paymentChoice) {
        return Payment.processPayment(paymentChoice);
    }

    public List<String> ship(String name, String streetAddress, String city, String state, String zip) {
        return Shipping.processShipping(name, streetAddress, city, state, zip);
    }
}
