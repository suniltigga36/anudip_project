package com.tigga.dao;

import com.tigga.model.Order;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

    public void placeOrder(Order order) {
        String query = "INSERT INTO `order` (UserID, RestaurantID, OrderDate, Status) VALUES (?, ?, NOW(), ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, order.getUserID());
            pstmt.setInt(2, order.getRestaurantID());
            pstmt.setString(3, order.getStatus());
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                order.setOrderID(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM `order`";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                orders.add(new Order(
                    rs.getInt("OrderID"),
                    rs.getInt("UserID"),
                    rs.getInt("RestaurantID"),
                    rs.getString("Status"),
                    rs.getTimestamp("OrderDate")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
}
