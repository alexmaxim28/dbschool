package com.example.tema_7.service;

import com.example.tema_7.exception.UserAlreadyExistException;
import com.example.tema_7.model.Customer;
import com.example.tema_7.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer getCustomerById(Integer id) {
        return customerRepository.getById(id);
    }

    public void addCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
    }

    public void deleteCustomer(Integer idClient) {
        customerRepository.delete(getCustomerById(idClient));
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }


    public boolean checkIfUserExist(String username) {
        return customerRepository.findCustomerByUsername(username) != null;
    }

    public void register(Customer customer) throws UserAlreadyExistException {

        if (checkIfUserExist(customer.getUsername())) {
            throw new UserAlreadyExistException();
        } else {
            Customer newCustomer = new Customer();
            newCustomer.setCity(customer.getCity());
            newCustomer.setCountry(customer.getCountry());
            newCustomer.setUsername(customer.getUsername());
            newCustomer.setUsername(customer.getUsername());
            BeanUtils.copyProperties(newCustomer, customer);
            customerRepository.save(newCustomer);
        }
    }

}