package com.example.demo.repository;

import com.example.demo.configuration.EmailConfiguration;
import com.example.demo.model.Cart;
import com.example.demo.model.OrderItem;
import com.example.demo.smtp.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class OrderItemRepositoryImpl implements OrderItemRepositoryCustom {

    @Autowired
    public EmailService emailService;

    @Override
    public String sendConfirmationEmail(OrderItem orderItem) {
        emailService.sendOrderConfirmationMessage(orderItem.getEmail(), orderItem.getItems());
        return "email is sent";
    }
}
