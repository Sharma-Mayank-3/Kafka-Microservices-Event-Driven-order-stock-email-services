package com.kafka.single.kafka;

import com.kafka.single.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaJsonConsumer {

    @KafkaListener(topics = "guides2", groupId = "myGroup")
    public void jsonConsumer(UserDto userDto){
        log.info("json consumed userDto :{}", userDto.toString());
    }

}
