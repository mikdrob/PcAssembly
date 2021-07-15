package com.example.demo.controller;

import com.example.demo.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/item")
public class ItemController {
    private final com.example.demo.service.ItemService service;

    @Autowired
    public ItemController(com.example.demo.service.ItemService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Item>> GetAllOrders() {
        return ResponseEntity.ok(service.GetAll());
    }

    @PostMapping
    public ResponseEntity<Item> PostOrder(@RequestBody Item item) {
        return ResponseEntity.ok(service.Add(item));
    }
}
