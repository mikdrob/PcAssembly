package com.example.demo.service;

import com.example.demo.model.OrderItem;
import com.example.demo.repository.OrderItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;

    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public List<OrderItem> GetAll() {
        return orderItemRepository.findAll();
    }

    public OrderItem Add(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }
}
