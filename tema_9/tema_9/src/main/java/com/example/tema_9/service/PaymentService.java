package com.example.tema_9.service;

import com.example.tema_9.model.PaymentMethod;
import com.example.tema_9.repository.CustomerRepository;
import com.example.tema_9.repository.OrderRepository;
import com.example.tema_9.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PaymentService {
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;

    public String Payment(Integer customerId, Integer orderId, PaymentMethod paymentMethod){
        if (orderRepository.getById(orderId).getPrice() < 5000.0)
            return "Customer with id: " + customerRepository.getById(customerId) + "payed: " + orderRepository.getById(orderId).getPrice() + "with: " + paymentMethod;
        else if (paymentMethod != PaymentMethod.CARD) {
            return "Invalid payment method!";
        }
        return "Customer with id: " + customerRepository.getById(customerId) + "payed: " + orderRepository.getById(orderId).getPrice() + "with: " + PaymentMethod.CARD;
    }
}
