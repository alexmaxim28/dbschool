package com.example.demo.dao;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class CustomerDAO implements DAO<Customer> {
    private final CustomerRepository customerRepository;

    @Override
    public Optional<Customer> get(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public void create(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public void update(Customer customer) {
        customerRepository.save(customer);
    }

    public List<Customer> getAll() {
        List <Customer> aux = new ArrayList<>();
        customerRepository.findAll().iterator().forEachRemaining(aux :: add);
        return aux;
    }

    public List<Customer> filterUsername(String username){
        return customerRepository.findByUsername(username);
    }

    public List<Customer> filterCity(String city){
        return customerRepository.findByCity(city);
    }

    public List<Customer> filterCountry(String country){
        return customerRepository.findByCountry(country);
    }

}
