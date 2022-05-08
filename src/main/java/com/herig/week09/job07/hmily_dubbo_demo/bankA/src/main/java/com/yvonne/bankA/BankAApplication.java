package com.yvonne.bankA;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RestController;


@ImportResource({"classpath:spring-dubbo.xml"})
@MapperScan({"com.yvonne.bankcommon.mapper"})
//@SpringBootApplication
@SpringBootApplication(exclude = {  MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@RestController
public class BankAApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAApplication.class, args);
    }

}
