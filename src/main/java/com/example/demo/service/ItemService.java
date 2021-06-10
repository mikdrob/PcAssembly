package com.example.demo.service;


import com.example.demo.model.Item;
import com.example.demo.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> GetAll() {
        return itemRepository.findAll();
    }

    public Item Add(Item person) {
        return itemRepository.save(person);
    }
}
