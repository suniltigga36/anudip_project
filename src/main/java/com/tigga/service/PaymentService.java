package com.tigga.service;

import com.tigga.dao.PaymentDAO;
import com.tigga.model.Payment;

public class PaymentService {
    private PaymentDAO paymentDAO = new PaymentDAO();

    public void processPayment(int orderID, double amount, String paymentStatus, String paymentMethod) {
        Payment payment = new Payment(0, orderID, amount, paymentStatus, paymentMethod);
        paymentDAO.processPayment(payment);
        System.out.println("Payment processed successfully!");
    }
}
