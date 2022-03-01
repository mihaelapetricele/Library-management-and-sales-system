package com.project.bookstore.model;

import java.util.Objects;

public class ProductInCartAsModel {
    private Long idProductBook;
    private Long id_book;
    private String bookName;
    private double price;
    private String image;
    private int cantity;

    public ProductInCartAsModel(Long idProductBook, Long id_book, String bookName, double price, String image, int cantity) {
        this.idProductBook = idProductBook;
        this.id_book = id_book;
        this.bookName = bookName;
        this.price = price;
        this.image = image;
        this.cantity = cantity;
    }

    public ProductInCartAsModel() {
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCantity() {
        return cantity;
    }

    public void setCantity(int cantity) {
        this.cantity = cantity;
    }

    public Long getId_book() {
        return id_book;
    }

    public void setId_book(Long id_book) {
        this.id_book = id_book;
    }

    public Long getIdProductBook() {
        return idProductBook;
    }

    public void setIdProductBook(Long idProductBook) {
        this.idProductBook = idProductBook;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductInCartAsModel that = (ProductInCartAsModel) o;
        return Double.compare(that.price, price) == 0 && cantity == that.cantity && Objects.equals(bookName, that.bookName) && Objects.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookName, price, image, cantity);
    }

    @Override
    public String toString() {
        return "ProductInCartAsModel{" +
                "id_book=" + id_book +
                ", bookName='" + bookName + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", cantity=" + cantity +
                '}';
    }
}
