package com.project.bookstore;
import com.project.bookstore.controller.BookController;
import com.project.bookstore.model.User;
import com.project.bookstore.service.BookService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ui.Model;

@SpringBootApplication(scanBasePackages = "com.project.bookstore")
public class BookStoreApplication {

    public static void main(String[] args) {
//        User user = new com.project.bookstore.model.User.UserBuilder()
//                .username("aaa")
//                .password("bbb")
//                .build();
        SpringApplication.run(BookStoreApplication.class, args);
    }

}
