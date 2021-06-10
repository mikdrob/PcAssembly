package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.model.Item;
import com.example.demo.service.CartService;
import com.example.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/v1/cart")
public class CartController {
    private final CartService service;

    @Autowired
    public CartController(CartService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Cart>> GetItems() {

        return ResponseEntity.ok(service.GetAll());
    }

    @PostMapping
    public ResponseEntity<Cart> PostCart(@RequestBody Cart cart){
        return ResponseEntity.ok(service.Add(cart));
    }
}
