package com.kafka.stockService.kafka;

import com.kafka.stockService.dto.OrderDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaCosnumer {

    @KafkaListener(topics = "guide", groupId = "stock", properties = {"spring.json.value.default.type=com.kafka.stockService.dto.OrderDto"})
    public void stockMessageCosnume(OrderDto orderDto){
      log.info("stock message consumed : {}", orderDto.toString());
    }

}
