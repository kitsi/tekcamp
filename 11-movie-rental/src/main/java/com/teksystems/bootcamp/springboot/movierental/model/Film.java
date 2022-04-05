package com.teksystems.bootcamp.springboot.movierental.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Film {

    @Id
    private Long filmId;

    private String title;

    @OneToMany(mappedBy = "review")
    private List<Review> reviews;

}
