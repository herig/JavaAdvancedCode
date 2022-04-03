package com.herig.week05.job10.jdbc03;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

@SpringBootApplication
@ConditionalOnMissingBean({DataSource.class})
public class StartJDBCApplication {

    @Resource
    HikariDataSource dataSource;


    public static void main(String[] args) {
        SpringApplication.run(StartJDBCApplication.class,args);
    }

    @Bean
    public void test() throws SQLException {
        Connection connection = dataSource.getConnection();
        DatabaseMetaData metaData = connection.getMetaData();

        //数据源>>>>>>class com.zaxxer.hikari.HikariDataSource
        System.out.println("数据源>>>>>>" + dataSource.getClass());
        System.out.println("连接>>>>>>>>" + connection);
        System.out.println("连接地址>>>>" + connection.getMetaData().getURL());
        System.out.println("驱动名称>>>>" + metaData.getDriverName());
        System.out.println("驱动版本>>>>" + metaData.getDriverVersion());
        System.out.println("数据库名称>>" + metaData.getDatabaseProductName());
        System.out.println("数据库版本>>" + metaData.getDatabaseProductVersion());
        System.out.println("连接用户名称>" + metaData.getUserName());

        connection.close();


    }

}
