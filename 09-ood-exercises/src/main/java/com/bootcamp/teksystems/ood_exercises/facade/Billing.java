package com.bootcamp.teksystems.ood_exercises.facade;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.*;

public class Billing {
    private final List<String> invoice = new ArrayList<>();
    private final static BigDecimal TAX_RATE = new BigDecimal("0.08");


    public List<String> createInvoice(Order order) {
        Map<Item, Integer> orderItems = order.getOrder();
        String lineItem;
        String quantity;
        BigDecimal amount;
        BigDecimal subtotal = BigDecimal.ZERO;
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        invoice.add("\n-------------------------------------------------");
        invoice.add("                    INVOICE");
        invoice.add("-------------------------------------------------");
        for(Map.Entry entry : orderItems.entrySet()) {
            lineItem = ((Item) entry.getKey()).name;
            quantity = (String.valueOf(entry.getValue()));
            amount = ((Item) entry.getKey()).price.multiply(new BigDecimal(quantity));
            invoice.add(String.format(" %-34s| %-15s", lineItem, formatter.format(amount)));
            subtotal = subtotal.add(amount);
        }
        invoice.add(String.format("\n %-34s| %-15s", "SUBTOTAL ", formatter.format(subtotal)));
        invoice.add(String.format(" %-34s| %-15s","TAX ", formatter.format(calculateTax(subtotal))));
        invoice.add(String.format(" %-34s| %-15s", "TOTAL ", formatter.format(calculateTotal(subtotal))));
        invoice.add("-------------------------------------------------\n");
        return invoice;
    }

    private BigDecimal calculateTax(BigDecimal subtotal) {
        return subtotal.multiply(TAX_RATE);
    }

    public BigDecimal calculateTotal(BigDecimal subtotal) {
        return subtotal.add(calculateTax(subtotal));
    }
}
