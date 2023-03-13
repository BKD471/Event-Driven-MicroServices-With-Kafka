package com.example.stockservice.service;

import com.example.basedomains.dto.OrderDto;
import com.example.basedomains.dto.OrderEventDto;
import com.example.stockservice.mapper.OrderMapper;
import com.example.stockservice.model.Order;
import com.example.stockservice.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderConsumer {

    private OrderRepository orderRepository;

    OrderConsumer(OrderRepository orderRepository){
        this.orderRepository=orderRepository;
    }

    @KafkaListener(topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}")
    public void consumeMessage(OrderEventDto eventDto){
        log.info(String.format("Msg consumed successfully %s",eventDto.toString()));
        OrderDto orderDto=eventDto.getOrder();
        Order fetchedOrder= OrderMapper.mapToOrder(orderDto);
        orderRepository.save(fetchedOrder);
    }

}
