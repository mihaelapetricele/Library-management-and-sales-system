package com.project.bookstore.repository;

import com.project.bookstore.model.Produs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Produs,Long> {

}
