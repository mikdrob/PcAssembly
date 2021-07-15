package com.example.demo.service;

import com.example.demo.model.Item;
import com.example.demo.repository.ItemRepository;
import javassist.NotFoundException;
import org.hibernate.annotations.NotFound;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

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

    public Item Get(Long id) {
        return itemRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Item Add(Item item) {
        return itemRepository.save(item);
    }
}
