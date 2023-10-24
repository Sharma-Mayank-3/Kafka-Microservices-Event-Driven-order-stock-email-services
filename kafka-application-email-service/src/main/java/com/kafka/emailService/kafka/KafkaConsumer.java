package com.kafka.emailService.kafka;

import com.kafka.emailService.dto.OrderDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "guide", groupId = "email", properties = {"spring.json.value.default.type=com.kafka.emailService.dto.OrderDto"})
    public void messageConsumer(OrderDto orderDto){
      log.info("message consumed : {}", orderDto.toString());
    }

}
