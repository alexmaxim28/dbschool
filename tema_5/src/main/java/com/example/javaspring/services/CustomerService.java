package com.example.javaspring.services;

import com.example.javaspring.model.Customer;
import com.example.javaspring.repostories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        List <Customer> aux = new ArrayList<>();
        customerRepository.findAll().iterator().forEachRemaining(aux :: add);
        return aux;
    }

    public Customer getCustomerById(@PathVariable int id){
       return customerRepository.getCustomerById(id);
    }

    public void updateCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
    }

    public void addCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
    }

    public void deleteCustomer(@PathVariable int id)
    {
        customerRepository.deleteById(id);
    }
}