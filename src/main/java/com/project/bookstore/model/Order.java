package com.project.bookstore.model;

public class Order {

    private int orderID;
    private String username;

    public Order(int orderID, String username) {
        this.orderID = orderID;
        this.username = username;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
