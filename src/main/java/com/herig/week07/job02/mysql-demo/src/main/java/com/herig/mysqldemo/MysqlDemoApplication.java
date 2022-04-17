package com.herig.mysqldemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.herig.mysqldemo.dao")
public class MysqlDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MysqlDemoApplication.class, args);
	}

}
