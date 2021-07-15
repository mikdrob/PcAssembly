package com.example.demo.repository;

import com.example.demo.model.OrderItem;
import com.example.demo.model.OrderItemKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemKey> {
}
