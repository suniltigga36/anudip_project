package com.tigga.service;

import com.tigga.dao.RestaurantDAO;
import com.tigga.model.Restaurant;
import java.util.List;

public class RestaurantService {
    private RestaurantDAO restaurantDAO = new RestaurantDAO();

    public void displayRestaurants() {
        List<Restaurant> restaurants = restaurantDAO.getAllRestaurants();
        for (Restaurant restaurant : restaurants) {
            System.out.println(restaurant.getRestaurantID() + " - " + restaurant.getName() +
                    " | Location: " + restaurant.getLocation() + " | Rating: " + restaurant.getRating());
        }
    }
}
