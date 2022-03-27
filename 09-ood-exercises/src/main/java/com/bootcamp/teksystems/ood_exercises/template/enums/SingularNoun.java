package com.bootcamp.teksystems.ood_exercises.template.enums;

public enum SingularNoun {
    HAND(1, "hand"),
    HIP(2, "hip"),
    SMILE(3, "smile"),
    QUEUE(4, "queue"),
    SCHOOL(5, "school"),
    MIND(6, "mind"),
    GROUP(7, "group"),
    GIRL(8, "girl"),
    POSTURE(9, "posture"),
    THROAT(10, "throat");

    public final int id;
    public final String name;

    SingularNoun(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
