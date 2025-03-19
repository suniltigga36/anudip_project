package com.tigga.model;

import java.sql.Timestamp;

public class Order {
    private int orderID;
    private int userID;
    private int restaurantID;
    private String status;
    private Timestamp orderDate;

    public Order(int orderID, int userID, int restaurantID, String status, Timestamp orderDate) {
        this.orderID = orderID;
        this.userID = userID;
        this.restaurantID = restaurantID;
        this.status = status;
        this.orderDate = orderDate;
    }

    public int getOrderID() { return orderID; }
    public void setOrderID(int orderID) { this.orderID = orderID; }

    public int getUserID() { return userID; }
    public void setUserID(int userID) { this.userID = userID; }

    public int getRestaurantID() { return restaurantID; }
    public void setRestaurantID(int restaurantID) { this.restaurantID = restaurantID; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Timestamp getOrderDate() { return orderDate; }
    public void setOrderDate(Timestamp orderDate) { this.orderDate = orderDate; }
}
