package com.kafka.single.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic getTopic(){
        return TopicBuilder.name("guides1").build();
    }

    @Bean
    public NewTopic getTopic2(){
        return TopicBuilder.name("guides2").build();
    }

}
