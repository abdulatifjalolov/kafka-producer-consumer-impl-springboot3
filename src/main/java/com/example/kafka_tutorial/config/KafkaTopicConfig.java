package com.example.kafka_tutorial.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic abduTopic() {
        return TopicBuilder.name("abdu").build();
    }

    @Bean
    public NewTopic abduJsonTopic() {
        return TopicBuilder.name("abdu-json").build();
    }
}
