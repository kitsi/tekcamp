package com.bootcamp.teksystems.ood_exercises.template.enums;

public enum Adverb {
    ALREADY(1, "already"),
    CAREFULLY(2, "carefully"),
    SLOPPILY(3, "sloppily"),
    HOPELESSLY(4, "hopelessly");

    public final int id;
    public final String name;

    Adverb(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
