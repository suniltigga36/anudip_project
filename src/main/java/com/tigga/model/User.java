package com.tigga.model;

public class User {
    private int userID;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String password;

    public User(int userID, String name, String email, String phone, String address, String password) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.password = password;
    }

    // Getters & Setters
    public int getUserID() { return userID; }
    public void setUserID(int userID) { this.userID = userID; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
