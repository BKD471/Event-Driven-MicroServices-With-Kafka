package com.example.orderservice.controller;

import com.example.basedomains.dto.OrderDto;
import com.example.basedomains.dto.OrderEventDto;
import com.example.orderservice.service.OrderProducer;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    private OrderProducer orderProducer;

    OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping("/publish")
    ResponseEntity<String> publishOrderEvents(@RequestBody OrderDto order) {
        //order.setOrderId(Long.parseLong(UUID.randomUUID()));
        //instantiate OrderEvent from basedomains and set the order and status
        OrderEventDto orderEvent=new OrderEventDto();
        orderEvent.setOrder(order);
        orderEvent.setStatus("AWAITING");
        orderEvent.setMessage("Order is waiting to be picked");

        //publish the event to kafka topic
        orderProducer.sendMessage(orderEvent);
        return new ResponseEntity<>("Ordered successfully", HttpStatus.CREATED);
    }

}
