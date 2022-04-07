package com.teksystems.bootcamp.springboot.movierental.controller;

import com.teksystems.bootcamp.springboot.movierental.model.Customer;
import com.teksystems.bootcamp.springboot.movierental.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public Page<Customer> getCustomers(
            @RequestParam(value = "pageNum", defaultValue = "0", required = false) int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize
    ) {
        return customerService.getCustomers(pageNum, pageSize);
    }

    @GetMapping("/{id}")
    public Optional<Customer> getCustomer(@PathVariable(value = "id") Short id) {
        return customerService.getCustomer(id);
    }
}
