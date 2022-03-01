package com.project.bookstore.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "wishlists")
public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idwishlist")
    private Long idProductCart;

    @Column(name = "username")
    private String username;

    @Column(name = "id_product")
    private Long idProduct;

    @Column(name = "price")
    private double price;

    public Wishlist(Long idProductCart, String username, Long idProduct, double price) {
        this.idProductCart = idProductCart;
        this.username = username;
        this.idProduct = idProduct;
        this.price = price;
    }

    public Wishlist(String username, Long idProduct, double price) {
        this.username = username;
        this.idProduct = idProduct;
        this.price = price;
    }

    public Wishlist() {

    }

    public Long getIdProductCart() {
        return idProductCart;
    }

    public void setIdProductCart(Long idProductCart) {
        this.idProductCart = idProductCart;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wishlist wishlist = (Wishlist) o;
        return Double.compare(wishlist.price, price) == 0 && Objects.equals(idProductCart, wishlist.idProductCart) && Objects.equals(username, wishlist.username) && Objects.equals(idProduct, wishlist.idProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProductCart, username, idProduct, price);
    }

    @Override
    public String toString() {
        return "Wishlist{" +
                "idProductCart=" + idProductCart +
                ", username='" + username + '\'' +
                ", idProduct=" + idProduct +
                ", price=" + price +
                '}';
    }
}
