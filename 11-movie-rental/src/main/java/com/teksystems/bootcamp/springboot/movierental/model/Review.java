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
    @JoinColumn(name = "customer_id")
    @Getter @Setter
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "film_id")
    @Getter @Setter
    private Film film;

    @ManyToOne
    @JoinColumn(name = "rating_id")
    @Getter @Setter
    private Rating rating;

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", customer=" + customer +
                ", film=" + film +
                ", rating=" + rating +
                '}';
    }
}
