package com.teksystems.bootcamp.capstone2.logic.menuitems;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Entree extends MenuItem{
    private List<Side> sides = new ArrayList<>();
    private List<Topping> toppings = new ArrayList<>();

    public Entree(String name, BigDecimal price, String description) {
        super(MenuCategory.ENTREE, name, description);
        this.price = price;
    }

    public List<Side> getSides() {
        return sides;
    }

    public void addEntreeSide(Side sideToAdd) {
        sides.add(sideToAdd);
    }

    public void removeEntreeSide(Side sideToRemove) {
        sides.remove(sideToRemove);
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void addEntreeTopping(Topping toppingToAdd) {
        toppings.add(toppingToAdd);
    }

    public void removeEntreeTopping(Topping toppingToRemove) {
        toppings.remove(toppingToRemove);
    }

    @Override
    public String toString() {
        return "Entree{" +
                "description='" + description + '\'' +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
