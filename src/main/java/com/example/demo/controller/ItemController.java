package com.example.demo.controller;

import com.example.demo.model.Item;
import com.example.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/v1/item")
public class ItemController {

    private final ItemService service;

    @Autowired
    public ItemController(ItemService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Item>> GetItems() {
        return ResponseEntity.ok(service.GetAll());
    }

    @CrossOrigin(maxAge = 3600)
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Item>> GetItem(@PathVariable("id") String id) {
        long result = Long.parseLong(id);
        return ResponseEntity.ok(service.Get(result));
    }


    @PostMapping
    public ResponseEntity<Item> PostItem(@RequestBody Item item){
        return ResponseEntity.ok(service.Add(item));
    }
}
