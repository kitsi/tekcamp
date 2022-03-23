package com.bootcamp.teksystems.ood_exercises.factories;

public class CoalElf implements IElf {
    @Override
    public Type deliver() {
        return Type.COAL;
    }
}
