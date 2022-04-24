package com.herig.week07.job09;

import com.herig.week05.job08.properties.Klass;
import com.herig.week05.job08.properties.Student;
import com.herig.week07.job09.datasource.DynamicDataSourceConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import java.util.ArrayList;
import java.util.List;

@MapperScan("com.herig.week07.job09.mapper")
@Import({DynamicDataSourceConfig.class})
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DataSourceApplication {


    public static void main(String[] args) {
        SpringApplication.run(DataSourceApplication.class,args);
    }


}
