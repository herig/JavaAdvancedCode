package com.herig.week05.job08;

import com.herig.week05.job08.properties.Klass;
import com.herig.week05.job08.properties.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class StartApplication {


    @Autowired
    private Student student;
    @Autowired
    private Klass klass;

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class,args);
    }

    @Bean
    public void test(){
        System.out.println(student.toString());
        System.out.println(klass.toString());
        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        klass.setStudents(studentList);
        klass.dong();
    }

}
