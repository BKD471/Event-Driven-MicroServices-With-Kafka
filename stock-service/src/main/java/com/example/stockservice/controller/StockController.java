package com.example.stockservice.controller;

import com.example.basedomains.dto.OrderDto;
import com.example.basedomains.dto.OrderEventDto;
import com.example.stockservice.mapper.OrderMapper;
import com.example.stockservice.model.Order;
import com.example.stockservice.repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/stock")
public class StockController {
   OrderRepository orderRepository;

   StockController(OrderRepository orderRepository){
       this.orderRepository=orderRepository;
   }
   @GetMapping
   public ResponseEntity<List<OrderDto>> getListOfOrders(){
        List<Order> orders=orderRepository.findAll();
        List<OrderDto> fetchedOrders=orders.stream().
                map(e -> OrderMapper.mapToOrderDto(e)).
                collect(Collectors.toList());
        return new ResponseEntity<>(fetchedOrders, HttpStatus.OK);
   }

}
