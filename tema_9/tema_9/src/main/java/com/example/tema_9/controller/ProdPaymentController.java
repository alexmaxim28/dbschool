package com.example.tema_9.controller;

import com.example.tema_9.model.PaymentMethod;
import com.example.tema_9.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.Service;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Profile("prod")
public class ProdPaymentController {

    private final PaymentService paymentService;
    @PostMapping("/prod/{customerId}/{orderID}/{paymentMethod}")

    public String pay(@PathVariable("customerId") Integer customerId, @PathVariable("orderId") Integer orderId, @PathVariable("paymentMethod") PaymentMethod paymentMethod) {
        return paymentService.Payment(customerId, orderId, paymentMethod);
    }
}
