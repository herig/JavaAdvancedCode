package com.herig.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void send(String topicName,String message){
        kafkaTemplate.send(topicName,message);
        log.info("Producer: send message: " + message);
    }

}
