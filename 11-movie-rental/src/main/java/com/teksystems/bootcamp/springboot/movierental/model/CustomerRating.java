package com.teksystems.bootcamp.springboot.movierental.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.stream.Stream;

public enum CustomerRating {
//    ZERO_STAR(0, "worst movie ever"),
//    ONE_STAR(1, "disappointing"),
//    TWO_STAR(2, "bearable"),
//    THREE_STAR(3, "just fine"),
//    FOUR_STAR(4, "pretty good"),
//    FIVE_STAR(5, "excellent");

//    @Id
//    @Column(name = "customer_rating_id")
//    @Getter
//    public int id;


//    CustomerRating(int id, String name) {
//        this.id = id;
//        this.name = name;
//    }

    ZERO_STAR("worst movie ever"),
    ONE_STAR("disappointing"),
    TWO_STAR("bearable"),
    THREE_STAR("just fine"),
    FOUR_STAR("pretty good"),
    FIVE_STAR("excellent");

    private String name;

    private CustomerRating(String name) {
        this.name = name;
    }

//    @Getter
//    @JsonValue
//    private String name;

    @JsonValue
    public String getName() {
        return name;
    }

    @JsonCreator
    public static CustomerRating decode(final String name) {
        return Stream.of(CustomerRating.values()).filter(targetEnum -> targetEnum.name.equals(name)).findFirst().orElse(null);
    }


}
