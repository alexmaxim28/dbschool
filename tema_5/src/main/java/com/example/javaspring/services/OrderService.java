package com.example.javaspring.services;


import com.example.javaspring.dto.OrderCreationDTO;
import com.example.javaspring.model.ClientOrder;
import com.example.javaspring.model.Customer;
import com.example.javaspring.repostories.CustomerRepository;
import com.example.javaspring.repostories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CustomerRepository customerRepository;

    public List<ClientOrder> getAllOrders(){
        List <ClientOrder> aux = new ArrayList<>();
        orderRepository.findAll().iterator().forEachRemaining(aux :: add);
        return aux;
    }

    public ClientOrder getOrderById(@PathVariable int id){
        return orderRepository.getOrderById(id);
    }

    public void updateOrder(@RequestBody ClientOrder order){
        orderRepository.save(order);
    }

    public void addOrder(@RequestBody ClientOrder order){
        orderRepository.save(order);
    }

    public void deleteOrder(@PathVariable int id){
        orderRepository.deleteById(id);
    }

    public void AddOrderWithCustomer(OrderCreationDTO dto){
        Customer customer = customerRepository.getCustomerById(dto.getCustomer_id());
        orderRepository.save(new ClientOrder(null, dto.getName(), customer));
    }
}
