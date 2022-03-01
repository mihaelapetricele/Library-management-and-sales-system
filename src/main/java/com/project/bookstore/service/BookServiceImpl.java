package com.project.bookstore.service;

import com.project.bookstore.model.Produs;
import com.project.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Produs> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void saveBooks(Produs produs) {
        this.bookRepository.save(produs);
    }

    @Override
    public Produs getProductById(long id) {
        Optional<Produs> optional = bookRepository.findById(id);
        Produs produs = null;
        if(optional.isPresent()){
            produs = optional.get();
        }else{
            throw new RuntimeException("Products is not found for id::" + id);
        }
        return produs;
    }

    @Override
    public void deleteProductById(long id) {
        this.bookRepository.deleteById(id);
    }


}
