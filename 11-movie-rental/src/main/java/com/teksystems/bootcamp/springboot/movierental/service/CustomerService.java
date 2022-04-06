package com.teksystems.bootcamp.springboot.movierental.service;

import com.teksystems.bootcamp.springboot.movierental.model.Customer;
import com.teksystems.bootcamp.springboot.movierental.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomer(Short id) {
        return customerRepository.findById(id);
    }
}
