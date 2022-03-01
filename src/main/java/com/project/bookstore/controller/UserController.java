package com.project.bookstore.controller;

import com.project.bookstore.model.User;
import com.project.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping (value = "/signup_form")

    public String getAllUsers(Model model)
    {
        List<User> users =  userService.getAllUsers();

        model.addAttribute("users", users);

        return "signup_form";
    }
}
