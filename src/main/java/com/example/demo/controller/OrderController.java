package com.example.demo.controller;

import com.example.demo.dto.OrderItemDto;
import com.example.demo.model.Item;
import com.example.demo.model.Order;
import com.example.demo.model.OrderItem;
import com.example.demo.service.ItemService;
import com.example.demo.service.OrderItemService;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    private final OrderService orderService;
    private final ItemService itemService;
    private final OrderItemService orderItemService;

    @Autowired
    public OrderController(OrderService orderService, ItemService itemService, OrderItemService orderItemService) {
        this.orderService = orderService;
        this.itemService = itemService;
        this.orderItemService = orderItemService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public @NotNull Iterable<Order> GetAllOrders() {
        return orderService.GetAll();
    }

    @PostMapping
    public ResponseEntity<Order> PostOrder(@RequestBody OrderForm orderForm) {
        List<OrderItemDto> formOrderItems = orderForm.getItemOrders();
        Order order = new Order();
        LocalDate date = LocalDate.of(2020, 1, 8);
        order.setDateCreated(date);
        order = this.orderService.Add(order);

        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderItemDto dto : formOrderItems) {
            Item testItem = itemService.Get(dto.getItem().getId());
            Order testOrder = order;
            Integer testQuantity = dto.getQuantity();
            OrderItem testOrderItem = new OrderItem(itemService.Get(dto.getItem().getId()), order, dto.getQuantity());
            orderItems.add(orderItemService.Add(new OrderItem(itemService.Get(dto.getItem().getId()), order, dto.getQuantity())));
        }
        order.setOrderItems(orderItems);
        order.setDateCreated(date);
        return ResponseEntity.ok(orderService.Add(order));
    }

    public static class OrderForm {

        private List<OrderItemDto> itemOrders;

        public List<OrderItemDto> getItemOrders() {
            return itemOrders;
        }

        public void setItemOrders(List<OrderItemDto> itemOrders) {
            this.itemOrders = itemOrders;
        }
    }
}

