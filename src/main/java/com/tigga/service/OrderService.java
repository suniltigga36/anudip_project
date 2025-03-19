package com.tigga.service;

import com.tigga.dao.OrderDAO;
import com.tigga.model.Order;
import java.util.List;

public class OrderService {
    private OrderDAO orderDAO = new OrderDAO();

    public void placeOrder(int userID, int restaurantID, String status) {
        Order order = new Order(0, userID, restaurantID, status, null);
        orderDAO.placeOrder(order);
        System.out.println("Order placed successfully! Order ID: " + order.getOrderID());
    }

    public void displayOrders() {
        List<Order> orders = orderDAO.getAllOrders();
        for (Order order : orders) {
            System.out.println("Order ID: " + order.getOrderID() + " | User ID: " + order.getUserID() +
                    " | Restaurant ID: " + order.getRestaurantID() + " | Status: " + order.getStatus() +
                    " | Date: " + order.getOrderDate());
        }
    }
}
