package com.teksystems.bootcamp.springboot.movierental.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "rating")
@NoArgsConstructor
@AllArgsConstructor
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rating_id")
    @Getter
    private Long ratingId;

    @Column(name = "num_stars")
    @Getter @Setter
    private int numStars;

    @Column(name = "description")
    @Getter @Setter
    private String description;
}
