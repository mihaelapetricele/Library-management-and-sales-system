package com.project.bookstore.repository;

import com.project.bookstore.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


@org.springframework.stereotype.Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query("SELECT u FROM User u WHERE u.username = ?1")
    public User findByUsername(String username);

//    public List <User>findByLastName(String nume);
//
//    public List <User>findByName(String prenume);
//
//    public List <User>findByEmail(String email);
//
//    public List <User>findByUsername(String username);
//
//    public List <User>findByPassword(String password);
//
//    public List <User>findByRole(String role);
}
