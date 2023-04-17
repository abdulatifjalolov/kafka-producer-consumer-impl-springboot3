package com.example.kafka_tutorial.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
public class KafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "abdu", groupId = "myGroup")
    public void consume(String message) {
        LOGGER.info(MessageFormat.format("Message received {0}", message));
    }
}
