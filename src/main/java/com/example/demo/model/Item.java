package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "items")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String Title;

    private Integer Price;

    private String pictureUrl;

    private Integer ItemsAvailable;


    public Item(String title, Integer price, String pictureUrl, Integer itemsAvailable) {
        Title = title;
        Price = price;
        this.pictureUrl = pictureUrl;
        this.ItemsAvailable = itemsAvailable;
    }

    public Item() {
    }


    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Integer getPrice() {
        return Price;
    }

    public void setPrice(Integer price) {
        Price = price;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getItemsAvailable() {
        return ItemsAvailable;
    }

    public void setItemsAvailable(Integer itemsAvailable) {
        ItemsAvailable = itemsAvailable;
    }


}
