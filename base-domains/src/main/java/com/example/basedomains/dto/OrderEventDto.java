package com.example.basedomains.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderEventDto {
    private String message;
    private String status;
    private OrderDto order;
}
