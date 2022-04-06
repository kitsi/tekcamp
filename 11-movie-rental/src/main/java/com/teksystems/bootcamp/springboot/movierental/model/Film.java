package com.teksystems.bootcamp.springboot.movierental.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "film")
@NoArgsConstructor
@AllArgsConstructor
public class Film {

    @Id
    @Column(name = "film_id ", columnDefinition = "SMALLINT UNSIGNED")
    @Getter @Setter
    private Short filmId;

    @Column(name = "title")
    @Getter @Setter
    private String title;
}
