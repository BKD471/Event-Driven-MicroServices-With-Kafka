package com.example.orderservice.service;

import com.example.basedomains.dto.OrderEventDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderProducer {
    private NewTopic topic;
    private KafkaTemplate<String, OrderEventDto> kafkaTemplate;
    OrderProducer(KafkaTemplate<String, OrderEventDto> kafkaTemplate,NewTopic topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic=topic;
    }

    public void sendMessage(OrderEventDto event) {
        log.info(String.format("Message sent successfully %s", event.toString()));
        //create message
        Message<OrderEventDto> message = MessageBuilder.withPayload(event).
                setHeader(KafkaHeaders.TOPIC,topic.name()).build();
        //public to topic
        kafkaTemplate.send(message);
    }

}
