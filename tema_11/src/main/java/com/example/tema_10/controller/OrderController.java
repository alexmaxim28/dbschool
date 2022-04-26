package com.example.tema_10.controller;

import com.example.tema_10.model.Order;
import com.example.tema_10.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/orderHistory/{userId}")
    public List<Order> findAllByUser(@PathVariable("userId") Long userId){
        return orderService.findAllByUser(userId);
    }

    @PostMapping("/placeOrder/{userId}")
    public Order placeOrder(@PathVariable("userId") Long userId){
        return orderService.placeOrder(userId);
    }

}
