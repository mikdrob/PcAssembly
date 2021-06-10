package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="carts")
public class Cart implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="item_id", nullable = false)
    private Item item;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="order_item_id", nullable = false)
    private OrderItem orderItem;

    public Cart(Item item, OrderItem orderItem) {
        this.item = item;
        this.orderItem = orderItem;
    }

    public Cart() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }


    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }
}
