package com.teksystems.bootcamp.springboot.movierental.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @Column(name = "customer_id", columnDefinition = "SMALLINT UNSIGNED")
    @Getter @Setter
    private Short customerId;

    @Column(name = "first_name")
    @Getter @Setter
    private String firstName;

    @Column(name = "last_name")
    @Getter @Setter
    private String lastName;
}
