package com.project.bookstore.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "products_cart")
public class ProductInCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproducts_cart")
    private Long idProductCart;

    @Column(name = "username")
    private String username;

    @Column(name = "id_product")
    private Long idProduct;

    @Column(name = "cantity")
    private int cantity;

    @Column(name = "price")
    private double price;

    public ProductInCart(Long idProductCart, String username, Long idProduct, int cantity, double price) {
        this.idProductCart = idProductCart;
        this.username = username;
        this.idProduct = idProduct;
        this.cantity = cantity;
        this.price = price;
    }

    public ProductInCart(String username, Long idProduct, int cantity, double price) {
        this.username = username;
        this.idProduct = idProduct;
        this.cantity = cantity;
        this.price = price;
    }

    public ProductInCart() {

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

    public int getCantity() {
        return cantity;
    }

    public void setCantity(int cantity) {
        this.cantity = cantity;
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
        ProductInCart that = (ProductInCart) o;
        return username == that.username && idProduct == that.idProduct && cantity == that.cantity && Double.compare(that.price, price) == 0 && Objects.equals(idProductCart, that.idProductCart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProductCart, username, idProduct, cantity, price);
    }

    @Override
    public String toString() {
        return "ProductInCart{" +
                "idProductCart=" + idProductCart +
                ", username=" + username +
                ", idProduct=" + idProduct +
                ", cantity=" + cantity +
                ", price=" + price +
                '}';
    }
}
