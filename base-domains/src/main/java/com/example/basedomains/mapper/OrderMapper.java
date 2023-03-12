package com.example.basedomains.mapper;

import com.example.basedomains.dto.OrderDto;
import com.example.basedomains.model.Order;

public class OrderMapper {
   public static Order mapToOrder(OrderDto orderDto){
       Order order=new Order();
       order.setOrderId(orderDto.getOrderId());
       order.setPrice(orderDto.getPrice());
       order.setName(orderDto.getName());
       order.setQuantity(orderDto.getQuantity());
       return order;
   }

    public static OrderDto mapToOrderDto(Order order){
        OrderDto orderDto=new OrderDto();
        orderDto.setOrderId(order.getOrderId());
        orderDto.setPrice(order.getPrice());
        orderDto.setName(order.getName());
        orderDto.setQuantity(order.getQuantity());
        return orderDto;
    }

}
