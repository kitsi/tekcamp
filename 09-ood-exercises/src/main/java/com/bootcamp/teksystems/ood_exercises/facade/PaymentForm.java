package com.bootcamp.teksystems.ood_exercises.facade;

public enum PaymentForm {
    PAYPAL("Paypal"),
    MASTERCARD("Mastercard"),
    VISA("Visa");

    public final String name;

    PaymentForm(String name) {
        this.name = name;
    }
}
