package com.teksystems.bootcamp.springboot.movierental.service;

import com.teksystems.bootcamp.springboot.movierental.model.Customer;
import com.teksystems.bootcamp.springboot.movierental.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Page<Customer> getCustomers(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
         Page<Customer> customers = customerRepository.findAll(pageable);
         return customers;
    }

    public Optional<Customer> getCustomer(Short id) {
        return customerRepository.findById(id);
    }
}
