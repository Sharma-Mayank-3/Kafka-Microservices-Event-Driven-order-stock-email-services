package com.kafka.single.controller;

import com.kafka.single.dto.UserDto;
import com.kafka.single.kafka.KafkaJsonPublisher;
import com.kafka.single.kafka.KafkaStringPublisher;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {

    @Autowired
    private KafkaStringPublisher kafkaStringPublisher;

    @Autowired
    private KafkaJsonPublisher kafkaJsonPublisher;

    @GetMapping("/publish")
    public ResponseEntity<String> publishKafkaStringMessage(
            @RequestParam(name = "message", required = false) String message
    ){
        kafkaStringPublisher.publishMessage(message);
        return new ResponseEntity<>("message published", HttpStatus.OK);
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publishJsonMessage(@RequestBody UserDto userDto){
        kafkaJsonPublisher.publishJsonMessage(userDto);
        return new ResponseEntity<>("json object published", HttpStatus.OK);
    }

}
