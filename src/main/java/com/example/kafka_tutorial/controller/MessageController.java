package com.example.kafka_tutorial.controller;

import com.example.kafka_tutorial.service.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
@RequiredArgsConstructor
public class MessageController {
    private final KafkaProducer kafkaProducer;


    @GetMapping("/publish")
    public ResponseEntity<String> publish(
            @RequestParam("message") String message
    ) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to the Topic");
    }
}
