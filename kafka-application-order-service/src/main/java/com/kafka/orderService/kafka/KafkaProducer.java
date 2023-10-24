package com.kafka.orderService.kafka;

import com.kafka.orderService.dto.OrderDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, OrderDto> kafkaTemplate;

    public void publishMessage(OrderDto orderDto){
        log.info("message published : {}", orderDto.toString());
        kafkaTemplate.send("guide", orderDto);
    }

}
