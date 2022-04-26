package com.example.tema_10.service;

import com.example.tema_10.model.Product;
import com.example.tema_10.model.User;
import com.example.tema_10.model.Wishlist;
import com.example.tema_10.repository.ProductRepository;
import com.example.tema_10.repository.UserRepository;
import com.example.tema_10.repository.WishlistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WishlistService {
    private final WishlistRepository wishlistRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public Wishlist getWishlistById(Long userId) {
        if (wishlistRepository.findWishlistByUserId(userId) != null)
            return wishlistRepository.findWishlistByUserId(userId);
        return null;
    }

    public List<Wishlist> getAllWishlists() {
        return wishlistRepository.findAll();
    }

    public void addWishlist(Wishlist wishlist) {
        wishlistRepository.save(wishlist);
    }

    public Wishlist deleteWishlist(Long id) {
       Wishlist wishlist = wishlistRepository.getById(id);
       wishlist.setProdInWishlist(new ArrayList<>());
       return wishlist;
    }

    public Wishlist addProductInWishlist(Long idUser, Long idProduct){
        Product p = productRepository.findById(idProduct).get();
        User u = userRepository.findById(idUser).get();
        Wishlist wishlist =  getWishlistById(idUser);
        wishlist.getProdInWishlist().add(p);
        return wishlistRepository.save(wishlist);
    }

    public Wishlist removeProductFromWishlist(Long idUser, Long idProduct){
        Product p = productRepository.findById(idProduct).get();
        User u = userRepository.findById(idUser).get();
        Wishlist wishlist =  getWishlistById(idUser);
        wishlist.getProdInWishlist().remove(p);
        return wishlistRepository.save(wishlist);
    }
}
