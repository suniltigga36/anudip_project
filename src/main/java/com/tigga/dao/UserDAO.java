package com.tigga.dao;

import com.tigga.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.*;

public class UserDAO {
    private static final Logger logger = LoggerFactory.getLogger(UserDAO.class);

    private static final String INSERT_USER_QUERY = 
        "INSERT INTO user (Name, Email, Phone, Address, Password) VALUES (?, ?, ?, ?, ?)";

    public void addUser(User user) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBConnection.getConnection();
            if (conn == null) {
                logger.error("Database connection failed!");
                return;
            }

            pstmt = conn.prepareStatement(INSERT_USER_QUERY);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPhone());
            pstmt.setString(4, user.getAddress());
            pstmt.setString(5, user.getPassword());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                logger.info("User added successfully: {}", user.getEmail());
            } else {
                logger.warn("No rows inserted for user: {}", user.getEmail());
            }

        } catch (SQLIntegrityConstraintViolationException e) {
            logger.error("Duplicate entry error: Email or Phone already exists! [{}]", user.getEmail());
        } catch (SQLException e) {
            logger.error("SQL Error adding user [{}]: {}", user.getEmail(), e.getMessage());
        } catch (Exception e) {
            logger.error("Unexpected error: {}", e.getMessage());
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                logger.error("Failed to close database resources: {}", e.getMessage());
            }
        }
    }
}
