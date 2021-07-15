package com.example.demo.service;


import com.example.demo.model.Order;
import com.example.demo.repository.OrderItemRepository;
import com.example.demo.repository.OrderRepository;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Iterable<Order> GetAll() {
        return orderRepository.findAll();
    }

    public Order Add(Order order) {
        return orderRepository.save(order);
    }



}
