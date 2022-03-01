package com.project.bookstore.service;

import com.project.bookstore.model.ProductInCart;
import com.project.bookstore.repository.ProductInCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductInCartService {

    @Autowired
    private ProductInCartRepository productsRepo;

    public ProductInCart addProductInCart(ProductInCart productInCart) {
        return productsRepo.save(productInCart);
    }

    public void deleteProductInCart(long id) {
        productsRepo.deleteById(id);
    }

    public List<ProductInCart> getAllProductsInCart() {
        return productsRepo.findAll();
    }

}
