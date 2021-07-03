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
public class OrderItemService{
    private final OrderItemRepository orderItemRepository;

    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public List<OrderItem> GetAll() {
        return orderItemRepository.findAll();
    }

    public Optional<OrderItem> Get(Long id) {

        return orderItemRepository.findById(id);
    }

    public OrderItem Add(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    public String SendEmailConfirmation(Long id){
        OrderItem orderItem = orderItemRepository.getById(id);
        return orderItemRepository.sendConfirmationEmail(orderItem);
    }
}
