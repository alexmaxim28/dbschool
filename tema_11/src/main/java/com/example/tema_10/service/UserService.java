package com.example.tema_10.service;

import com.example.tema_10.model.Cart;
import com.example.tema_10.model.User;
import com.example.tema_10.model.Wishlist;
import com.example.tema_10.repository.CartRepository;
import com.example.tema_10.repository.UserRepository;
import com.example.tema_10.repository.WishlistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final WishlistRepository wishlistRepository;
    private final CartRepository cartRepository;

    public User getUserById(Long id) {
        if(userRepository.findById(id).isPresent())
            return userRepository.getById(id);
        return null;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails) userRepository.findUserByUsername(username);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        Cart cart = new Cart();
        cart.setCartEntries(new ArrayList<>());
        cart.setUser(user);
        Wishlist wishlist = new Wishlist();
        wishlist.setProdInWishlist(new ArrayList<>());
        wishlist.setUser(user);
        user = userRepository.save(user);
        wishlist = wishlistRepository.save(wishlist);
        cart = cartRepository.save(cart);
        user.setCart(cart);
        user.setWishlist(wishlist);

        return user;
    }

    public String deleteUser(Long id) {
        if(getUserById(id) != null){
            userRepository.delete(getUserById(id));
            return "User deleted";
        }
        return "User not found";
    }

    public String updateUser(User user){
        deleteUser(user.getId());
        addUser(user);
        return "User updated";
    }
}
