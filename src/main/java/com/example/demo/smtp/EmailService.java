package com.example.demo.smtp;

import com.example.demo.model.Cart;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;


public interface EmailService {
    void sendOrderConfirmationMessage(String to, List<Cart> items);

}
