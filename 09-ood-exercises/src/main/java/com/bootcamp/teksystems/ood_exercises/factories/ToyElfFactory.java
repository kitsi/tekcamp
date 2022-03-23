package com.bootcamp.teksystems.ood_exercises.factories;

public class ToyElfFactory extends ElfAbstractFactory {
    @Override
    public IElf createElf() {
        IElf elf = new ToyElf();
        return elf;
    }
}
