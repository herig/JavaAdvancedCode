package com.herig.week05.job02.spring03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public Klass createKlass(){
        return new Klass();
    }

    @Bean("student1")
    public Student createStudent(){
        return new Student(1,"小明",20);
    }
}
