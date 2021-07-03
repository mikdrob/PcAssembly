package com.example.demo.controller;

import com.example.demo.model.Item;
import com.example.demo.model.OrderItem;
import com.example.demo.service.ItemService;
import com.example.demo.service.OrderItemService;
import com.example.demo.smtp.EmailService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;


@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/v1/order_item")
public class OrderItemController {
    private final OrderItemService service;


    @Autowired
    public EmailService emailService;

    @Autowired
    public OrderItemController(OrderItemService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<OrderItem>> GetOrderItems() {
        return ResponseEntity.ok(service.GetAll());
    }

    @CrossOrigin(maxAge = 3600)
    @GetMapping("/{id}")
    public ResponseEntity<Optional<OrderItem>> GetOrderItemById(@PathVariable("id") String id) {
        long result = Long.parseLong(id);
        return ResponseEntity.ok(service.Get(result));
    }

    @CrossOrigin(maxAge = 3600)
    @PostMapping
    public ResponseEntity<OrderItem> PostOrderItem(@RequestBody OrderItem orderItem){
        return ResponseEntity.ok(service.Add(orderItem));
    }

    @CrossOrigin(maxAge = 3600)
    @GetMapping("/mail/{id}")
    public ResponseEntity<String> sendEmail(@PathVariable String id){
        long orderId = Long.parseLong(id);
        return ResponseEntity.ok(service.SendEmailConfirmation(orderId));
    }
}
