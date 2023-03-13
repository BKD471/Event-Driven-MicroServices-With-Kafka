package com.example.stockservice.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long orderId;
    private String name;
    private int quantity;
    private double price;

}
