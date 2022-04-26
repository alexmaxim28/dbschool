package com.example.tema_10.service;

import com.example.tema_10.model.Cart;
import com.example.tema_10.model.Order;
import com.example.tema_10.model.User;
import com.example.tema_10.repository.CartRepository;
import com.example.tema_10.repository.OrderRepository;
import com.example.tema_10.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final UserRepository userRepository;

    public List<Order> findAllByUser(Long userId){
        return orderRepository.findAllByUserId(userId);
    }

    public Order placeOrder(Long userId){
        Cart cart = cartRepository.findCartByUserId(userId);
        if(cart == null)
            return null;
        else
        {
            //create the order
            Order order = new Order();
            User user = cart.getUser();
            order.setCartEntries(cart.getCartEntries());
            order.setUser(user);

            //clear cart
            cart.setCartEntries(new ArrayList<>());
            user.getOrderHistory().add(order);

            orderRepository.save(order);
            cartRepository.save(cart);
            userRepository.save(user);
            return order;
        }
    }

}
