package com.example.tema_10.service;

import com.example.tema_10.model.*;
import com.example.tema_10.repository.CartRepository;
import com.example.tema_10.repository.ProductRepository;
import com.example.tema_10.repository.UserRepository;
import com.example.tema_10.repository.WishlistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public Cart getCartById(Long userId) {
        //If there is an user with that id, return his cart
        if (cartRepository.findCartByUserId(userId) != null)
            return cartRepository.findCartByUserId(userId);
        return null;
    }

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public Cart removeCart(Long id) {
        Cart cart = getCartById(id);
        //Clear list product.
        cart.setCartEntries(new ArrayList<CartEntry>());
        return cartRepository.save(cart);
    }

    public Cart addProductInCart(Long idUser, Long idProduct, int quantity) {
        Product p = productRepository.findById(idProduct).get();
        User u = userRepository.findById(idUser).get();
        Cart cart = getCartById(idUser);

        //Check if product is in User's cart, if so, update it's quantity.
        for (CartEntry ce : cart.getCartEntries()) {
            if (ce.getProduct().getId().equals(idProduct)) {
                ce.setQuantity(ce.getQuantity() + quantity);
                return cartRepository.save(cart);
            }
        }

        //If not, just create a new CartEntry and add it to Cart.
        CartEntry cartEntry = new CartEntry();
        cartEntry.setCart(cart);
        cartEntry.setProduct(p);
        cartEntry.setQuantity(quantity);

        cart.getCartEntries().add(cartEntry);

        return cartRepository.save(cart);
    }

    public Cart removeProductFromCart(Long idUser, Long idProduct) {
        Product p = productRepository.findById(idProduct).get();
        User u = userRepository.findById(idUser).get();
        Cart cart = getCartById(idUser);

        cart.getCartEntries().remove(p);
        return cartRepository.save(cart);
    }

    //an endpoint where i can get all the carts from all the users,
    //sorted by the total of the products
    public List<Cart> getAllOrdersSorted(){
        return cartRepository.findAll().stream().sorted().collect(Collectors.toList());
    }
}
