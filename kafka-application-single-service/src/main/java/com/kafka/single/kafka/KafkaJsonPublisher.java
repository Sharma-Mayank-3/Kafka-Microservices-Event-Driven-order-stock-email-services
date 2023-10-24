package com.kafka.single.kafka;

import com.kafka.single.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaJsonPublisher {

    @Autowired
    private KafkaTemplate<String, UserDto> kafkaTemplate;

    public void publishJsonMessage(UserDto userDto){
        log.info("json published userDto :{}", userDto.toString());
        kafkaTemplate.send("guides2", userDto);
    }

}
