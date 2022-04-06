package com.example.demo.controller;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.model.Customer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class DemoController {

    CustomerDAO customerdao;

    @GetMapping("/filterUsername")
    public List<Customer> filterUsername(@RequestParam ("username") String username){
        return customerdao.filterUsername(username);
    }

    @GetMapping("/filterCity")
    public List<Customer> filterCity(@RequestParam ("city") String city){
        return customerdao.filterCity(city);
    }

    @GetMapping("/filterCountry")
    public List<Customer> filterCountry(@RequestParam ("country") String country){
        return customerdao.filterCountry(country);
    }

    @PostMapping("/customers")
    public void addCustomer(@RequestBody Customer customer)
    {
        customerdao.create(customer);
    }

    @GetMapping("/view")
    public ModelAndView displayView() {
        List<Customer> customers = new ArrayList<>();

        customers.add(new Customer(1,"username1","city1","country1"));
        customers.add(new Customer(2,"username2","city2","country2"));
        customers.add(new Customer(3,"username3","city3","country3"));

        ModelAndView modelAndView = new ModelAndView("view-pages");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
}
