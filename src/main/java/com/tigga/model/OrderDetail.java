package com.tigga.model;

public class OrderDetail {
    private int orderDetailID;
    private int orderID;
    private int foodID;
    private int quantity;

    public OrderDetail(int orderDetailID, int orderID, int foodID, int quantity) {
        this.orderDetailID = orderDetailID;
        this.orderID = orderID;
        this.foodID = foodID;
        this.quantity = quantity;
    }

    public int getOrderDetailID() { return orderDetailID; }
    public void setOrderDetailID(int orderDetailID) { this.orderDetailID = orderDetailID; }

    public int getOrderID() { return orderID; }
    public void setOrderID(int orderID) { this.orderID = orderID; }

    public int getFoodID() { return foodID; }
    public void setFoodID(int foodID) { this.foodID = foodID; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
