package com.bootcamp.teksystems.ood_exercises.factories;

public class CoalElfFactory extends ElfAbstractFactory {

    @Override
    public IElf createElf() {
        IElf elf = new CoalElf();
        return elf;
    }
}
