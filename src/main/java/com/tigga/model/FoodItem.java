package com.tigga.model;

public class FoodItem {
    private int foodID;
    private String name;
    private double price;
    private int restaurantID;

    public FoodItem(int foodID, String name, double price, int restaurantID) {
        this.foodID = foodID;
        this.name = name;
        this.price = price;
        this.restaurantID = restaurantID;
    }

    public int getFoodID() { return foodID; }
    public void setFoodID(int foodID) { this.foodID = foodID; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getRestaurantID() { return restaurantID; }
    public void setRestaurantID(int restaurantID) { this.restaurantID = restaurantID; }
}
