package com.example.javaspring.repostories;

import com.example.javaspring.model.ClientOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<ClientOrder, Integer> {
    public ClientOrder getOrderById(Integer id);
}
