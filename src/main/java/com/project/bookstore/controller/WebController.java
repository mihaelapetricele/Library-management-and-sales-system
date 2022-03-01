package com.project.bookstore.controller;

import com.project.bookstore.model.User;
import com.project.bookstore.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

    @Autowired
    private UserRepository userRepo;

    @RequestMapping("/home")
    public ModelAndView homePage() {
        return new ModelAndView("home");
    }

    @RequestMapping("/products")
    public ModelAndView productsPage() {
        return new ModelAndView("products");
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "signup_form";
    }
    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepo.save(user);

        return "signup_form";
    }

    @RequestMapping("/adminPage")
    public ModelAndView AdminPage() {
        return new ModelAndView("adminPage");
    }

    @RequestMapping("/transportorPage")
    public ModelAndView TransportorPage() {
        return new ModelAndView("transportorPage");
    }

   /* @RequestMapping("/wishlist")
    public ModelAndView WishlistPage() {
        return new ModelAndView("wishlistPage");
    }*/

    @RequestMapping("/orderPage")
    public ModelAndView OrderPage() {
        return new ModelAndView("orderPage");
    }

    @RequestMapping("/about")
    public ModelAndView AboutPage() {
        return new ModelAndView("about");
    }

    @RequestMapping("/aboutLogin")
    public ModelAndView AboutPageLogin() {
        return new ModelAndView("aboutLogin");
    }

    @RequestMapping("/contact")
    public ModelAndView ContactPage() {
        return new ModelAndView("contact");
    }
    @RequestMapping("/contactLogin")
    public ModelAndView ContactPageLogin() {
        return new ModelAndView("contactLogin");
    }

    @RequestMapping("/deleteClients")
    public ModelAndView ManageClients() {
        return new ModelAndView("deleteClients");
    }

    @GetMapping("favicon.ico")
    @ResponseBody
    public void disableFavicon() {
        //Method is void to avoid browser 404 issue by returning nothing in the response.
    }
}