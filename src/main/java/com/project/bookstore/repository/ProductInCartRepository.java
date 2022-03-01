package com.project.bookstore.repository;

import com.project.bookstore.model.ProductInCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInCartRepository extends JpaRepository<ProductInCart, Long> {
}
