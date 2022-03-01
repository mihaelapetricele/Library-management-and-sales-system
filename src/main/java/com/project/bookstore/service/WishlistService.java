package com.project.bookstore.service;

import com.project.bookstore.model.ProductInCart;
import com.project.bookstore.model.Wishlist;
import com.project.bookstore.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;

    public Wishlist addInWishlist(Wishlist product) {
        return wishlistRepository.save(product);
    }

    public void deleteFromWishlist(long id) {
        wishlistRepository.deleteById(id);
    }

    public List<Wishlist> getAllProductsFromWishlist() {
        return wishlistRepository.findAll();
    }
}
