package com.teksystems.bootcamp.springboot.movierental.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "actor")
@NoArgsConstructor
@Getter
public class Actor {

    @Id
    @Column(name = "actor_id")
    @Getter
    private int actorId;

    @Column(name = "first_name")
    @Getter
    private String firstName;

    @Column(name = "last_name")
    @Getter
    private String lastName;
}
