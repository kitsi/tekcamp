package com.teksystems.bootcamp.springboot.movierental.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "film")
@NoArgsConstructor
@Getter
public class Film {

    @Id
    @Column(name = "film_id")
    @Getter
    private int filmId;

    @Column(name = "title")
    @Getter
    private String title;

}
