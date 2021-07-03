package com.example.demo.smtp;

import com.example.demo.dto.EmailItems;

import java.util.List;

public interface EmailService {
    void sendOrderConfirmationMessage(String to, List<EmailItems> items);

}
