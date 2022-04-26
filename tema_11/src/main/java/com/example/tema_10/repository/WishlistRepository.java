package com.example.tema_10.repository;

import com.example.tema_10.model.Cart;
import com.example.tema_10.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
    public Wishlist findWishlistByUserId(Long userId);
}
