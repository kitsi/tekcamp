package com.bootcamp.teksystems.ood_exercises.facade;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<Item, Integer> inventory = new HashMap<>();

    public Inventory() {
        this.inventory = makeInitialStock();
    }

    public int getStock(Item itemtoCheck) {
        int stock = 0;
        for(Item item : Item.values()) {
            if(itemtoCheck.equals(item)) {
                stock = inventory.get(item);
            }
        }
        return stock;
    }

    private Map<Item, Integer> makeInitialStock() {
        for(Item item : Item.values()) {
            inventory.put(item, 10);
        }
        return inventory;
    }

    public void removeFromInventory(Item itemToRemove, int quantity) {
        if(inStock(itemToRemove, quantity)) {
            for(Item item : Item.values()) {
                if(itemToRemove.equals(item)) {
                    inventory.put(item, inventory.get(item) - quantity);
                }
            }
        }
    }

    public boolean inStock(Item itemToCheck, int quantity) {
        boolean inStock = false;
        for(Item item : Item.values()) {
             if(itemToCheck.equals(item)) {
                 inStock = (inventory.get(itemToCheck) >= quantity);
            }
        }
        return inStock;
    }
}
