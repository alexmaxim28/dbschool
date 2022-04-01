package com.example.javaspring.repostories;

import com.example.javaspring.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    public Customer getCustomerById(int id);
}
