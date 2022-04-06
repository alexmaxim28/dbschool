package com.example.demo.dao;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class CustomerDAO implements DAO<CustomerDAO> {
    private final CustomerRepository customerRepository;

    @Override
    public Optional<CustomerDAO> get(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public void create(CustomerDAO customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(CustomerDAO customer) {
        customerRepository.delete(customer);
    }

    @Override
    public void update(CustomerDAO customer) {
        customerRepository.save(customer);
    }

    public List<CustomerDAO> getAll() {
        List <CustomerDAO> aux = new ArrayList<>();
        customerRepository.findAll().iterator().forEachRemaining(aux :: add);
        return aux;
    }

    public List<CustomerDAO> filterUsername(String username){
        return customerRepository.findByUsername(username);
    }

    public List<CustomerDAO> filterCity(String city){
        return customerRepository.findByCity(city);
    }

    public List<CustomerDAO> filterCountry(String country){
        return customerRepository.findByCountry(country);
    }

}
