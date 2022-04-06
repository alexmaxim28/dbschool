package com.example.demo.repository;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.dao.ProductDAO;
import com.example.demo.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository <Customer, Integer>{
    public List<Customer> findByUsername(String name);
    public List<Customer> findByCity(String city);
    public List<Customer> findByCountry(String country);
}
