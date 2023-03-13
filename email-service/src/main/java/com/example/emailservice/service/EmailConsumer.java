package com.example.emailservice.service;

import com.example.basedomains.dto.OrderEventDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailConsumer {

    @KafkaListener(topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}")
    public void consumeMessage(OrderEventDto eventDto){
        log.info(String.format("Message Consumed successfully %s",
                eventDto.toString()));
        //Invoke an email sending api
    }

}
