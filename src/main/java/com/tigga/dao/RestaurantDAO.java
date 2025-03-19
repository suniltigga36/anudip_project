package com.tigga.dao;

import com.tigga.model.Restaurant;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RestaurantDAO {

    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> restaurants = new ArrayList<>();
        String query = "SELECT * FROM restaurant";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                restaurants.add(new Restaurant(
                    rs.getInt("RestaurantID"),
                    rs.getString("Name"),
                    rs.getString("Location"),
                    rs.getFloat("Rating")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurants;
    }
}
