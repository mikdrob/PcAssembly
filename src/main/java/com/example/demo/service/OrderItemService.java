package com.example.demo.service;


import com.example.demo.configuration.EmailConfiguration;
import com.example.demo.model.Cart;
import com.example.demo.model.Item;
import com.example.demo.model.OrderItem;
import com.example.demo.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;

    private final EmailConfiguration emailService;

    public OrderItemService(OrderItemRepository orderItemRepository, EmailConfiguration emailService) {
        this.orderItemRepository = orderItemRepository;
        this.emailService = emailService;
    }

    public List<OrderItem> GetAll() {
        return orderItemRepository.findAll();
    }

    public Optional<OrderItem> Get(Long id) {
        OrderItem test = orderItemRepository.getById(id);
        List<Cart> cart = test.getItems();
        for (Cart cart1:cart
             ) {
            cart1.getItem().
        }
        return orderItemRepository.findById(id);
    }

    public OrderItem Add(OrderItem orderItem) {
//        emailService.getJavaMailSender().sendOrderConfirmationMessage(orderItem.getEmail());
        return orderItemRepository.save(orderItem);
    }
}
