package com.herig.week05.job02.spring03;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
public class Student {

    private int id;

    private String name;

    private int age;

    public Student(int id,String name,int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

}
