package com.tigga.dao;

import com.tigga.model.Payment;
import java.sql.*;

public class PaymentDAO {

    public void processPayment(Payment payment) {
        String query = "INSERT INTO payment (OrderID, Amount, PaymentStatus, PaymentMethod) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, payment.getOrderID());
            pstmt.setDouble(2, payment.getAmount());
            pstmt.setString(3, payment.getPaymentStatus());
            pstmt.setString(4, payment.getPaymentMethod());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
