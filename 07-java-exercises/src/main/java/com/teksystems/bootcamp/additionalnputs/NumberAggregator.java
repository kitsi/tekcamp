package com.teksystems.bootcamp.additionalnputs;

public class NumberAggregator {
    private int total;

    public int getTotal() {
        return this.total;
    }

    public void addNumber(int numberToAdd) {
        this.total += numberToAdd;
    }
}
