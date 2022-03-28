package com.bootcamp.teksystems.ood_exercises.template.enums;

public enum Gerund {
    TRYING(1, "trying"),
    REMOVING(2, "removing"),
    RINSING(3, "rinsing"),
    REATTACHING(4, "reattaching"),
    ATTEMPTING(5, "attempting"),
    SCREAMING(6, "screaming"),
    RUNNING(7, "running"),
    LOLLING(8, "lolling"),
    GROANING(9, "groaning"),
    SHAMBLING(10, "shambling");

    public final int id;
    public final String name;

    Gerund(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
