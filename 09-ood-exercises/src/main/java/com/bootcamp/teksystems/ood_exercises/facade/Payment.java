package com.bootcamp.teksystems.ood_exercises.facade;

public class Payment {

    public static String getPaymentOptions() {
        String sf1 = PaymentOption.PAYPAL.name;
        String sf2 = PaymentOption.MASTERCARD.name;
        String sf3 = PaymentOption.VISA.name;
        return String.format("1) %s, 2) %s, 3) %s", sf1, sf2, sf3);
    }

    public static String processPayment(int paymentChoice) {
        String paymentOption = "";
        for(PaymentOption option : PaymentOption.values()) {
            if(option.id == paymentChoice) {
                paymentOption = option.name;
            }
        }
        return paymentOption + " has been charged\n";
    }
}
