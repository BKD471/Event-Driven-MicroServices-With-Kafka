package com.example.stockservice.service;

import com.example.basedomains.dto.OrderDto;
import com.example.basedomains.dto.OrderEventDto;
import com.example.basedomains.repository.OrderRepository;
import com.example.basedomains.service.OrderDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderConsumer {

    @KafkaListener(topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}")
    public void consumeMessage(OrderEventDto eventDto){
        log.info(String.format("Msg consumed successfully %s",eventDto));
//        OrderDao orderDao=new OrderDao();
//        orderDao.fetchOrders(eventDto);
    }

}
