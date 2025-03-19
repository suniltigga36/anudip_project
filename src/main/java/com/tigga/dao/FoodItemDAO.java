package com.tigga.dao;

import com.tigga.model.FoodItem;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FoodItemDAO {
    
    public List<FoodItem> getAllFoodItems() {
        List<FoodItem> foodItems = new ArrayList<>();
        String query = "SELECT * FROM fooditem";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                foodItems.add(new FoodItem(
                    rs.getInt("FoodID"),
                    rs.getString("Name"),
                    rs.getDouble("Price"),
                    rs.getInt("RestaurantID")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foodItems;
    }

    public void addFoodItem(FoodItem food) {
        String query = "INSERT INTO fooditem (Name, Price, RestaurantID) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, food.getName());
            pstmt.setDouble(2, food.getPrice());
            pstmt.setInt(3, food.getRestaurantID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
