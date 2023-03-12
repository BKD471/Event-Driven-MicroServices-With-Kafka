package com.example.basedomains.service;

import com.example.basedomains.dto.OrderDto;
import com.example.basedomains.dto.OrderEventDto;
import com.example.basedomains.mapper.OrderMapper;
import com.example.basedomains.model.Order;
import com.example.basedomains.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderDao {

    @Autowired
    private OrderRepository orderRepository;

    public  void fetchOrders(OrderEventDto orderEventDto){
        OrderDto orderDto=orderEventDto.getOrder();
        Order order= OrderMapper.mapToOrder(orderDto);
        Order fetchedOrder=orderRepository.save(order);
    }
}
