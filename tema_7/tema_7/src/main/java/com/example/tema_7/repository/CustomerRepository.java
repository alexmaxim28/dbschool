package com.example.tema_7.repository;

import com.example.tema_7.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    public Customer findCustomerByUsername(String username);
}
