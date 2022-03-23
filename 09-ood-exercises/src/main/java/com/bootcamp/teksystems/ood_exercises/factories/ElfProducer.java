package com.bootcamp.teksystems.ood_exercises.factories;

public class ElfProducer {
    public static ElfAbstractFactory createElf(Type elfFactoryType) {
        ElfAbstractFactory elfFactory = null;
        if(elfFactoryType.equals(Type.COAL)) {
            elfFactory = new CoalElfFactory();
        } else if(elfFactoryType.equals(Type.TOY)) {
            elfFactory = new ToyElfFactory();
        }
        return elfFactory;
    }
}
