package com.example.tema_7.controller;

import com.example.tema_7.exception.UserAlreadyExistException;
import com.example.tema_7.model.Customer;
import com.example.tema_7.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable int id)
    {
        return customerService.getCustomerById(id);
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable int id)
    {
        customerService.deleteCustomer(id);
    }

    @PostMapping("/customers/register")
    public String registerCustomer(@RequestBody Customer customer){
        try{
            customerService.register(customer);
        } catch (UserAlreadyExistException e) {
            e.printStackTrace();
            return "Username already registered";
        }
        return "User registered";
    }

    @PostMapping("/customers/login")
    public String loginCustomer(@RequestBody Customer customer, HttpServletResponse response){
        if (customerService.checkCredientials(customer.getUsername(), customer.getPassword()))
        {
            Cookie cookie = new Cookie("userId", customer.getUsername());
            response.addCookie(cookie);
            return "Login succesful";
        }
        return "Wrong credientials";
    }

    @GetMapping("/customers/info_customer")
    public String printCookie(@CookieValue(name = "userId", defaultValue = "notLoggedIn")String usernameLoggedIn){
        if(usernameLoggedIn.equals("notLoggedIn"))
            return "Not logged in";
        return usernameLoggedIn;
    }

}
