package com.herig.week05.job08.config;

import com.herig.week05.job08.properties.Student;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(Student.class)
public class StudentConfig {

}
