package com.teksystems.bootcamp.springboot.movierental.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
@NoArgsConstructor
@Getter
public class Customer {

    @Id
    @Column(name = "customer_id")
    @Getter
    private int customerId;

    @Column(name = "first_name")
    @Getter
    private String firstName;

    @Column(name = "last_name")
    @Getter
    private String lastName;
}
