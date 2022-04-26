package com.example.tema_10.controller;

import com.example.tema_10.model.Wishlist;
import com.example.tema_10.repository.WishlistRepository;
import com.example.tema_10.service.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WishlistController {
    private final WishlistService wishlistService;

    @GetMapping("/getUserWishlist/{id}")
    public Wishlist getWishlistById(@PathVariable Long id){
        return wishlistService.getWishlistById(id);
    }

    @PostMapping("/addProductInWishlist/{userId}/{productId}")
    public Wishlist addProduct(@PathVariable("userId") Long userId, @PathVariable("productId") Long productId){
        return wishlistService.addProductInWishlist(userId, productId);
    }

    @DeleteMapping("/deleteProdFromWishlist/{userId}/{productId}")
    public Wishlist removeProduct(@PathVariable("userId") Long userId, @PathVariable("productId") Long productId){
        return wishlistService.removeProductFromWishlist(userId, productId);
    }

    @DeleteMapping("/clearWishlist/{id}")
    public Wishlist clearWishlist(@PathVariable("id") Long id){
        return wishlistService.deleteWishlist(id);
    }
}
