package com.herig.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class KafkaApplication {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext = SpringApplication.run(KafkaApplication.class, args);
        KafkaProducer kafkaProducer = applicationContext.getBean(KafkaProducer.class);
        String topicName = "KafkaTest";
        for(int i=0;i<10;i++){
            String Message = "hello,Kafka! I am " + i;
            kafkaProducer.send(topicName,Message);
            Thread.sleep(100);
        }
    }

}
