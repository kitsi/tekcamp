package com.teksystems.bootcamp.springboot.movierental.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    private int customerId;

    private String firstName;

    private String lastName;
}
