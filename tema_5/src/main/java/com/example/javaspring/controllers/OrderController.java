package com.example.javaspring.controllers;

import com.example.javaspring.dto.OrderCreationDTO;
import com.example.javaspring.model.ClientOrder;
import com.example.javaspring.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/orders")
    public List<ClientOrder> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/orders/{id}")
    public ClientOrder getOrderById(@PathVariable Integer id){
        return orderService.getOrderById(id);
    }

    @PostMapping("/orders")
    public void CreateOrder(@RequestBody OrderCreationDTO dto)
    {
        orderService.AddOrderWithCustomer(dto);
    }

    @PostMapping("/orders/update")
    public void updateOrder(@RequestBody ClientOrder order){
        orderService.updateOrder(order);
    }

    @DeleteMapping("/orders/{id}")
    public void deleteOrder(@PathVariable Integer id){
        orderService.deleteOrder(id);
    }

}
