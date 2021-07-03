package com.example.demo.repository;

import com.example.demo.model.OrderItem;

public interface OrderItemRepositoryCustom{
    String sendConfirmationEmail(OrderItem orderItem);
}
