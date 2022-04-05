package com.teksystems.bootcamp.springboot.movierental.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "review")
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    @Getter @Setter
    private Long reviewId;

    @Column(name = "film_id")
    @Getter @Setter
    private Integer film;

    @Column(name = "customer_id")
    @Getter @Setter
    private Integer customer;

    @Column(name = "name")
    @Getter @Setter
    private CustomerRating customerRating;
}
