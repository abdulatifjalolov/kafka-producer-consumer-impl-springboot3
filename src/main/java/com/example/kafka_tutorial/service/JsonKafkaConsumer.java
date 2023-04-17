package com.example.kafka_tutorial.service;

import com.example.kafka_tutorial.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
public class JsonKafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    @KafkaListener(topics = "abdu-json",groupId = "myGroup")
    public void consume(User user) {
            LOGGER.info(MessageFormat.format("Json message received {0}",user.toString()));
    }
}
