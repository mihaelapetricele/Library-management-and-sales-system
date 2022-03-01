package com.project.bookstore.repository;

import com.project.bookstore.model.Produs;
import com.project.bookstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Produs,Long> {
}
