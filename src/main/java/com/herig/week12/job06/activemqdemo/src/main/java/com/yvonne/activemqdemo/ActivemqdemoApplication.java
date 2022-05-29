package com.yvonne.activemqdemo;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.jms.*;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
public class ActivemqdemoApplication {

    public static void main(String[] args) {

        // 定义Destination topic
        Destination destinationTopic = new ActiveMQTopic("test.topic.herig");
        activeDestination(destinationTopic);
        Destination destinationQueue = new ActiveMQQueue("test.queue.herig");
        activeDestination(destinationQueue);

    }

    public static void activeDestination(Destination destination) {
        try {
            //activemq连接
            ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
            Connection connection = activeMQConnectionFactory.createConnection();
            connection.start();
            //session
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            //创建消费者
            MessageConsumer consumer = session.createConsumer(destination);
            final AtomicInteger atomicInteger = new AtomicInteger(0);
            MessageListener messageListener = new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    try {
                        System.out.println(atomicInteger.incrementAndGet() + "===" + destination.toString() + message);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            consumer.setMessageListener(messageListener);

            //创建生产者
            MessageProducer producer = session.createProducer(destination);
            int i = 0;
            while (i < 100) {
                i++;
                TextMessage message = session.createTextMessage("herig-" + i);
                producer.send(message);
            }

            Thread.sleep(20000);
            session.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}

