package com.kafka.single.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaStringPublisher {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void publishMessage(String message){
        log.info("message publish : {}", message);
        kafkaTemplate.send("guides1", message);
    }

}
