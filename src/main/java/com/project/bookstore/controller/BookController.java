package com.project.bookstore.controller;

import com.project.bookstore.model.ProductInCart;
import com.project.bookstore.model.ProductInCartAsModel;
import com.project.bookstore.model.Produs;
import com.project.bookstore.model.Wishlist;
import com.project.bookstore.repository.AdminRepository;
import com.project.bookstore.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private ProductInCartService productInCartService;

    @Autowired
    private WishlistService wishlistService;

    //display list of books
    @GetMapping("/productsList")
    public String showProducts(Model model) {
        model.addAttribute("listBooks", bookService.getAllBooks());
        return "productsList";
    }
    @Autowired
    AdminRepository adminRepo;
    // Add new books
    @GetMapping("/addProducts")
    public String AddProductsForm(Model model) {
        model.addAttribute("produs", new Produs());
        return "addProducts";
    }
    @PostMapping("/process_addProd")
    public String processRegister(Produs produs) {
        bookService.saveBooks(produs);
        return "redirect:/productsList";
    }

    //update books
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable (value = "id") long id, Model model){

        //get product from the service
        Produs produs = bookService.getProductById(id);

        //set product as a model attribute to pre-populate the form
        model.addAttribute("produs", produs);
        return "editProducts";
    }

    //delete books
    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable (value = "id") long id){

        //call delete product method
        this.bookService.deleteProductById(id);
        return "redirect:/productsList";
    }

    //add books in chart
    @GetMapping("/addBookInCart/{id}")
    public String addBookInCart(@PathVariable (value = "id") long id){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        ProductInCart product = new ProductInCart();

        Produs produs = bookService.getProductById(id);
        product.setIdProduct(id);
        product.setUsername(currentPrincipalName);
        product.setCantity(1);
        product.setPrice(produs.getPret());

        //call delete product method
        productInCartService.addProductInCart(product);
        return "redirect:/shopCart";
    }
    //delete books from chart
    @GetMapping("/deleteProductFromCart/{id}")
    public String deleteFromChart(@PathVariable (value = "id") long id){

        //call delete product method
        this.productInCartService.deleteProductInCart(id);
        return "redirect:/shopCart";
    }

    //show books in cart
    @GetMapping("/shopCart")
    public String shopCart(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        List<ProductInCart> products = new ArrayList<>();
        List<ProductInCart> allProduct = productInCartService.getAllProductsInCart();

        for(ProductInCart product : allProduct) {
            if(Objects.equals(product.getUsername(), currentPrincipalName)) {
                products.add(product);
            }
        }

        List<ProductInCartAsModel> productModel = new ArrayList<>();
        double price = 0;
        for(ProductInCart product : products) {
            Produs produs = bookService.getProductById(product.getIdProduct());

            ProductInCartAsModel productInCartAsModel = new ProductInCartAsModel();
            productInCartAsModel.setBookName(produs.getTitlu());
            productInCartAsModel.setImage(produs.getImagine());
            productInCartAsModel.setCantity(product.getCantity());
            productInCartAsModel.setPrice(product.getPrice());
            productInCartAsModel.setId_book(product.getIdProduct());
            productInCartAsModel.setIdProductBook(product.getIdProductCart());

            price += productInCartAsModel.getPrice();

            productModel.add(productInCartAsModel);
        }

        model.addAttribute("productList", productModel);
        model.addAttribute("totalPrice", price);
        return "shopCart";
    }



    //add books in wishlist
    @GetMapping("/addBookInWishlist/{id}")
    public String addBookInWishlist(@PathVariable (value = "id") long id){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        Wishlist wishlist = new Wishlist();

        Produs produs = bookService.getProductById(id);
        wishlist.setIdProduct(id);
        wishlist.setUsername(currentPrincipalName);
        wishlist.setPrice(produs.getPret());

        wishlistService.addInWishlist(wishlist);
        return "redirect:/wishlistPage";
    }
    //delete books from wishlist
    @GetMapping("/deleteProductFromWishlist/{id}")
    public String deleteProductFromWishlist(@PathVariable (value = "id") long id){

        //call delete product method
        this.wishlistService.deleteFromWishlist(id);
        return "redirect:/wishlistPage";
    }

    //show books in wishlist
    @GetMapping("/wishlistPage")
    public String wishlist(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        List<Wishlist> products = new ArrayList<>();
        List<Wishlist> allProduct = wishlistService.getAllProductsFromWishlist();

        for(Wishlist wishlist: allProduct) {
            if(Objects.equals(wishlist.getUsername(), currentPrincipalName)) {
                products.add(wishlist);
            }
        }

        List<ProductInCartAsModel> productModel = new ArrayList<>();
        for(Wishlist product : products) {
            Produs produs = bookService.getProductById(product.getIdProduct());

            ProductInCartAsModel productInCartAsModel = new ProductInCartAsModel();
            productInCartAsModel.setBookName(produs.getTitlu());
            productInCartAsModel.setImage(produs.getImagine());
            productInCartAsModel.setPrice(product.getPrice());
            productInCartAsModel.setId_book(product.getIdProduct());
            productInCartAsModel.setIdProductBook(product.getIdProductCart());

            productModel.add(productInCartAsModel);
        }

        model.addAttribute("productWishlist", productModel);
        return "wishlistPage";
    }


    //display all books
    @GetMapping("/products")
    public String showBooks(Model model) {
        model.addAttribute("listBooks", bookService.getAllBooks());
        return "products";
    }


    //display all books
    @GetMapping("/{type}")
    public String showBooksType(Model model, @PathVariable (value = "type") String type) {
        List<Produs> allBooks = bookService.getAllBooks();
        List<Produs> filterBooks = new ArrayList<>();
        for(Produs produs:allBooks)
        {
            if(Objects.equals(produs.getGen(), type)){
                filterBooks.add(produs);
            }
        }
        model.addAttribute("listBooksFilter", filterBooks);
        return type;
    }

    @GetMapping("/{type}" + "Login")
    public String showBooksTypeAfterLogin(Model model, @PathVariable (value = "type") String type) {
        List<Produs> allBooks = bookService.getAllBooks();
        List<Produs> filterBooks = new ArrayList<>();
        for(Produs produs:allBooks)
        {
            if(Objects.equals(produs.getGen(), type)){
                filterBooks.add(produs);
            }
        }
        model.addAttribute("listBooksFilterAfterLogin", filterBooks);
        return type + "Login";
    }

    @GetMapping("/productsLogin")
    public String showBooksAfterLogin(Model model) {
        model.addAttribute("listBooks", bookService.getAllBooks());
        return "productsLogin";
    }

}
