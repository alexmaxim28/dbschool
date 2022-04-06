package com.example.demo.controller;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.model.Customer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class DemoController {


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
