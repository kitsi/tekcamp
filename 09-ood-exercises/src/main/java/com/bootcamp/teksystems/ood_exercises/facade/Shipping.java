package com.bootcamp.teksystems.ood_exercises.facade;

import java.util.ArrayList;
import java.util.List;

public class Shipping {

    public static List<String> processShipping(String name, String streetAddress, String city, String state, String zip) {
        List<String> shippingDetails = new ArrayList<>();
        shippingDetails.add("Order has been shipped to:");
        shippingDetails.add(name);
        shippingDetails.add(streetAddress);
        shippingDetails.add(city);
        shippingDetails.add(state + " " + zip + "\n");
        return shippingDetails;
    }
}
