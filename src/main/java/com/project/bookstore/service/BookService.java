package com.project.bookstore.service;

import com.project.bookstore.model.Produs;

import java.util.List;

public interface BookService {

    List<Produs> getAllBooks();
    void saveBooks(Produs produs);
    Produs getProductById(long id);
    void deleteProductById(long id);
}
