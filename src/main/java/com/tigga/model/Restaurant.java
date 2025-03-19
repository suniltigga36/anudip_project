package com.tigga.model;

public class Restaurant {
    private int restaurantID;
    private String name;
    private String location;
    private float rating;

    public Restaurant(int restaurantID, String name, String location, float rating) {
        this.restaurantID = restaurantID;
        this.name = name;
        this.location = location;
        this.rating = rating;
    }

    // ✅ Ensure these getter methods exist
    public int getRestaurantID() { return restaurantID; }
    public String getName() { return name; }
    public String getLocation() { return location; }
    public float getRating() { return rating; }
}
