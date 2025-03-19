package com.tigga.service;

import com.tigga.dao.UserDAO;
import com.tigga.model.User;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    public void registerUser(String name, String email, String phone, String address, String password) {
        if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || address.isEmpty() || password.isEmpty()) {
            System.out.println("Error: All fields are required!");
            return;
        }
        if (password.length() < 6) {
            System.out.println("Error: Password must be at least 6 characters long!");
            return;
        }

        User user = new User(0, name, email, phone, address, password);
        userDAO.addUser(user);
    }
}
