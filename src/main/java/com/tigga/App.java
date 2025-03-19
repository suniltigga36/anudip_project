package com.tigga;

import com.tigga.service.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FoodService foodService = new FoodService();
        OrderService orderService = new OrderService();
        RestaurantService restaurantService = new RestaurantService();
        UserService userService = new UserService();
        PaymentService paymentService = new PaymentService();

        while (true) {
            System.out.println("\n===== FOOD DELIVERY SYSTEM =====");
            System.out.println("1. View Food Items");
            System.out.println("2. Place an Order");
            System.out.println("3. View Restaurants");
            System.out.println("4. Register a User");
            System.out.println("5. Process Payment");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.println("\n--- Food Items ---");
                        foodService.displayFoodItems();
                        break;

                    case 2:
                        System.out.println("\n--- Place an Order ---");
                        System.out.print("Enter User ID: ");
                        int userID = getIntInput(scanner);
                        System.out.print("Enter Restaurant ID: ");
                        int restaurantID = getIntInput(scanner);
                        System.out.print("Enter Order Status (Pending/Completed): ");
                        String status = scanner.nextLine().trim();

                        if (!status.equalsIgnoreCase("Pending") && !status.equalsIgnoreCase("Completed")) {
                            System.out.println("Invalid status! Must be 'Pending' or 'Completed'.");
                        } else {
                            orderService.placeOrder(userID, restaurantID, status);
                        }
                        break;

                    case 3:
                        System.out.println("\n--- Restaurants ---");
                        restaurantService.displayRestaurants();
                        break;

                    case 4:
                        System.out.println("\n--- Register User ---");
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine().trim();
                        System.out.print("Enter Email: ");
                        String email = scanner.nextLine().trim();
                        System.out.print("Enter Phone (10-digit number): ");
                        String phone = scanner.nextLine().trim();
                        System.out.print("Enter Address: ");
                        String address = scanner.nextLine().trim();
                        System.out.print("Enter Password (Min 6 characters): ");
                        String password = scanner.nextLine().trim();

                        if (!isValidEmail(email)) {
                            System.out.println("❌ Invalid email format!");
                        } else if (!phone.matches("\\d{10}")) {
                            System.out.println("❌ Invalid phone number! Must be 10 digits.");
                        } else if (password.length() < 6) {
                            System.out.println("❌ Password must be at least 6 characters long!");
                        } else {
                            userService.registerUser(name, email, phone, address, password);
                        }
                        break;

                    case 5:
                        System.out.println("\n--- Process Payment ---");
                        System.out.print("Enter Order ID: ");
                        int orderID = getIntInput(scanner);
                        System.out.print("Enter Amount: ");
                        double amount = getDoubleInput(scanner);
                        System.out.print("Enter Payment Status (Paid/Pending): ");
                        String paymentStatus = scanner.nextLine().trim();
                        System.out.print("Enter Payment Method (Credit Card/Cash/UPI): "); // 🛠 Updated message
                        String paymentMethod = scanner.nextLine().trim();

                        if (!paymentStatus.equalsIgnoreCase("Paid") && !paymentStatus.equalsIgnoreCase("Pending")) {
                            System.out.println("Invalid payment status! Must be 'Paid' or 'Pending'.");
                        } else if (!paymentMethod.equalsIgnoreCase("Credit Card") && 
                                   !paymentMethod.equalsIgnoreCase("Cash") && 
                                   !paymentMethod.equalsIgnoreCase("UPI")) {
                            System.out.println("Invalid payment method! Must be 'Credit Card', 'Cash', or 'UPI'."); // 🛠 Updated message
                        } else {
                            paymentService.processPayment(orderID, amount, paymentStatus, paymentMethod);
                        }
                        break;

                    case 6:
                        System.out.println("Exiting... Thank you!");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice! Please enter a number between 1 and 6.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    // Helper method to validate email
    private static boolean isValidEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    // Helper method to safely get an integer input
    private static int getIntInput(Scanner scanner) {
        while (true) {
            try {
                int value = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    // Helper method to safely get a double input
    private static double getDoubleInput(Scanner scanner) {
        while (true) {
            try {
                double value = scanner.nextDouble();
                scanner.nextLine();
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }
}
