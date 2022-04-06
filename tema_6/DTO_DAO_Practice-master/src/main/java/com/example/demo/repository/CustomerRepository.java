package com.example.demo.repository;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.dao.ProductDAO;
import com.example.demo.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository <CustomerDAO, Integer>{
    public List<CustomerDAO> findByUsername(String name);
    public List<CustomerDAO> findByCity(String city);
    public List<CustomerDAO> findByCountry(String country);
}
