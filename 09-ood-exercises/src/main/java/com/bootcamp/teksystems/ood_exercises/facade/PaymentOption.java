package com.bootcamp.teksystems.ood_exercises.facade;

public enum PaymentOption {
    PAYPAL(1, "Paypal"),
    MASTERCARD(2, "Mastercard"),
    VISA(3, "Visa");

    public final int id;
    public final String name;

    PaymentOption(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
