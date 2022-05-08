package com.yvonne.bankB;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RestController;

@ImportResource({"classpath:spring-dubbo.xml"})
@SpringBootApplication(exclude = {  MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@MapperScan({"com.yvonne.bankcommon.mapper"})
@RestController
public class BankBApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankBApplication.class, args);
    }

}
