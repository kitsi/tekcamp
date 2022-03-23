package com.bootcamp.teksystems.ood_exercises.factories;

public class ToyElf implements IElf {
    @Override
    public Type deliver() {
        return Type.TOY;
    }
}
