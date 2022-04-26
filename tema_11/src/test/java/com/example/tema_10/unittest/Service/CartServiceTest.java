package com.example.tema_10.unittest.Service;

import com.example.tema_10.model.Cart;
import com.example.tema_10.model.CartEntry;
import com.example.tema_10.model.Product;
import com.example.tema_10.model.User;
import com.example.tema_10.repository.CartRepository;
import com.example.tema_10.repository.ProductRepository;
import com.example.tema_10.repository.UserRepository;
import com.example.tema_10.service.CartService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class CartServiceTest {
    private UserRepository userRepository;
    private CartRepository cartRepository;
    private ProductRepository productRepository;

    private CartService cartService;
    private User user;
    private Cart cart;
    private Product product;
    private CartEntry cartEntry;

    @BeforeEach
    void init(){
        cartService = new CartService(cartRepository, userRepository, productRepository);
        user = new User(1L, "Mircea", null, null, null);
        cart = new Cart(1L, new ArrayList<>(), user);
        product = new Product(1L, "water", 2.35F, null);
        cartEntry = new CartEntry(1L, 1, product, cart, null);
        user.setCart(cart);
    }

    @Test
    void givenUserId_whenGetById_thenReturnNull(){
        Mockito.when(userRepository.findById(1L)).thenReturn(null);
        Cart c = cartService.getCartById(1L);
        assert c == null;
    }
}
