package com.herig.week05.job02.spring02;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component("student1")
public class Student {

    @Value("1")
    private int id;

    @Value("张三2")
    private String name;

    @Value("18")
    private int age;

}
