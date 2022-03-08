package com.teksystems.bootcamp.factorByTwo;

public class ValueNode extends Node{
    private int integerToEvaluate;

    public ValueNode(int integerToEvaluate) {
        this.integerToEvaluate = integerToEvaluate;
    }

    @Override
    public int getCountOfTwos() {
        return (integerToEvaluate == 2) ? 1 : 0;
    }
}
