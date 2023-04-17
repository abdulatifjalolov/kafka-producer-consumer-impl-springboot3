package com.example.kafka_tutorial.service;

import com.example.kafka_tutorial.model.User;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
@RequiredArgsConstructor
public class JsonKafkaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);
    private final KafkaTemplate<String, User> kafkaTemplate;

    public void sendMessage(User data) {
        LOGGER.info(MessageFormat.format("Data sent {0}", data.toString()));

        Message<User> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, "abdu-json")
                .build();

        kafkaTemplate.send(message);
    }
}
