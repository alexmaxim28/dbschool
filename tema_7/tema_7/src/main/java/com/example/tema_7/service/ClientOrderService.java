package com.example.tema_7.service;

import com.example.tema_7.model.ClientOrder;
import com.example.tema_7.model.Customer;
import com.example.tema_7.repository.ClientOrderRepository;
import com.example.tema_7.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientOrderService {
    private final ClientOrderRepository clientOrderRepository;

    public ClientOrder getClientOrderById(Integer id)
    {
        return clientOrderRepository.getById(id);
    }

    public void addClientOrder(ClientOrder clientOrder)
    {
        clientOrderRepository.save(clientOrder);
    }

    public void deleteClientOrder(ClientOrder clientOrder)
    {
        clientOrderRepository.delete(clientOrder);
    }

    public List<ClientOrder> getAllClientsOrders()
    {
        return clientOrderRepository.findAll();
    }
}
