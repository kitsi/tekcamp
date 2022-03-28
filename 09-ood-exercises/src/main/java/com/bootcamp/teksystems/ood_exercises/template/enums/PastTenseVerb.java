package com.bootcamp.teksystems.ood_exercises.template.enums;

public enum PastTenseVerb {
    STOOD(1, "stood"),
    USED(2, "used"),
    WORKED(3, "worked"),
    CAME(4, "came"),
    THOUGHT(5, "thought"),
    SUGGESTED(6, "suggested"),
    REALIZED(7, "realized"),
    RUBBED(8, "rubbed"),
    CLEARED(9, "cleared");

    public final int id;
    public final String name;

    PastTenseVerb(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
