package com.example.javaspring.controllers;

import com.example.javaspring.model.Customer;
import com.example.javaspring.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomersController {

    @Autowired
    CustomerService customerService;


    @GetMapping("/customers")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable int id)
    {
        return customerService.getCustomerById(id);
    }

    @PostMapping("/customers")
    public void createCustomer(@RequestBody Customer customer){
         customerService.addCustomer(customer);
    }

    @PostMapping("/customers/update")
    public void updateCustomer(@RequestBody Customer customer) {
        customerService.updateCustomer(customer);
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable int id)
    {
        customerService.deleteCustomer(id);
    }

}
