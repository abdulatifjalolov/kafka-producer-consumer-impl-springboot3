package com.example.kafka_tutorial.controller;

import com.example.kafka_tutorial.model.User;
import com.example.kafka_tutorial.service.JsonKafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
@RequiredArgsConstructor
public class JsonMessageController {

    private final JsonKafkaProducer kafkaProducer;

    @PostMapping("/publish")
    public ResponseEntity<?> publish(
            @RequestBody User user
            ) {
        kafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Json message sent to Kafka Topic");
    }
}
