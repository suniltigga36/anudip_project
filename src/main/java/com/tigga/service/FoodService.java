package com.tigga.service;

import com.tigga.dao.FoodItemDAO;
import com.tigga.model.FoodItem;
import java.util.List;

public class FoodService {
    private FoodItemDAO foodItemDAO = new FoodItemDAO();

    public void displayFoodItems() {
        List<FoodItem> foodItems = foodItemDAO.getAllFoodItems();
        for (FoodItem food : foodItems) {
            System.out.println(food.getFoodID() + " - " + food.getName() + " - $" + food.getPrice());
        }
    }

    public void addFoodItem(String name, double price, int restaurantID) {
        FoodItem food = new FoodItem(0, name, price, restaurantID);
        foodItemDAO.addFoodItem(food);
        System.out.println("Food item added successfully!");
    }
}
