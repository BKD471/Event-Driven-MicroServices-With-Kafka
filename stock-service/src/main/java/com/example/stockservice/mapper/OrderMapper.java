package com.example.stockservice.mapper;

import com.example.basedomains.dto.OrderDto;
import com.example.stockservice.model.Order;

public class OrderMapper {

    public static Order mapToOrder(OrderDto orderDto){
        Order order=new Order();
        order.setName(orderDto.getName());
        order.setPrice(orderDto.getPrice());
        order.setQuantity(orderDto.getQuantity());
        order.setOrderId(orderDto.getOrderId());
        return order;
    }

    public static OrderDto mapToOrderDto(Order order){
        OrderDto orderDto=new OrderDto();
        orderDto.setName(order.getName());
        orderDto.setPrice(order.getPrice());
        orderDto.setQuantity(order.getQuantity());
        orderDto.setOrderId(order.getOrderId());
        return orderDto;
    }


}
