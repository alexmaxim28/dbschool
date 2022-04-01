package com.example.javaspring.repostories;


import com.example.javaspring.model.OrderDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepository extends CrudRepository<OrderDetails, Integer> {
    public OrderDetails getOrderDetailsById(Integer id);
}
