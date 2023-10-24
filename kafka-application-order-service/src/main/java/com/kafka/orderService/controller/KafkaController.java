package com.kafka.orderService.controller;

import com.kafka.orderService.dto.OrderDto;
import com.kafka.orderService.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @PostMapping("/publish")
    public ResponseEntity<String> placeOrder(@RequestBody OrderDto orderDto){
        kafkaProducer.publishMessage(orderDto);
        return new ResponseEntity<>("order-placed", HttpStatus.CREATED);
    }

}
