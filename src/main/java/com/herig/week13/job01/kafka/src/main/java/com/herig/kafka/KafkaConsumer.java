package com.herig.kafka;


import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "KafkaTest")
    public void onMessage(String message){
        log.info("Consumer: received message: " + message);
    }
}
