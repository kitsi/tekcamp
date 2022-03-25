package com.bootcamp.teksystems.ood_exercises.facade;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Billing {
    private final Map<String, String> invoice = new HashMap<>();
//    private final List<String> invoice = new ArrayList<>();
    private final static BigDecimal TAX_RATE = new BigDecimal("0.08");


    public Map<String, String> createInvoice(Order order) {
        Map<Item, Integer> orderItems = order.getOrder();
        String lineItem;
        String quantity;
        BigDecimal amount;
        BigDecimal subtotal = BigDecimal.ZERO;
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        for(Map.Entry entry : orderItems.entrySet()) {
            lineItem = ((Item) entry.getKey()).name;
            quantity = (String.valueOf(entry.getValue()));
            amount = ((Item) entry.getKey()).price.multiply(new BigDecimal(quantity));
            invoice.put(lineItem, formatter.format(amount));
            subtotal.add(amount);
        }
        invoice.put("SUBTOTAL", formatter.format(subtotal));
        invoice.put("TAX", formatter.format(calculateTax(subtotal)));
        invoice.put("TOTAL", formatter.format(calculateTotal(subtotal)));
        return invoice;
    }

    private BigDecimal calculateTax(BigDecimal subtotal) {
        return subtotal.multiply(TAX_RATE);
    }

    public BigDecimal calculateTotal(BigDecimal subtotal) {
        return subtotal.add(calculateTax(subtotal));
    }

}
