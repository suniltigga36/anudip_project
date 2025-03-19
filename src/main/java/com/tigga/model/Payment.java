package com.tigga.model;

public class Payment {
    private int paymentID;
    private int orderID;
    private double amount;
    private String paymentStatus;
    private String paymentMethod;

    public Payment(int paymentID, int orderID, double amount, String paymentStatus, String paymentMethod) {
        this.paymentID = paymentID;
        this.orderID = orderID;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
        this.paymentMethod = paymentMethod;
    }

    public int getPaymentID() { return paymentID; }
    public void setPaymentID(int paymentID) { this.paymentID = paymentID; }

    public int getOrderID() { return orderID; }
    public void setOrderID(int orderID) { this.orderID = orderID; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
}
