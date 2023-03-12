package com.example.basedomains.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long orderId;
    private String name;
    private int quantity;
    private double price;
}
