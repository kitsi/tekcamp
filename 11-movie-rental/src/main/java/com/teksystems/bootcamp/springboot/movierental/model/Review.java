package com.teksystems.bootcamp.springboot.movierental.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long reviewId;

    @ManyToOne
    @JoinColumn(referencedColumnName = "customer_id")
    @Getter @Setter
    private Customer customer;

    @ManyToOne
    @JoinColumn(referencedColumnName = "film_id")
    @Getter @Setter
    private Film film;

    @ManyToOne
    @JoinColumn(referencedColumnName = "rating_id")
    @Getter @Setter
    private Rating rating;
}
