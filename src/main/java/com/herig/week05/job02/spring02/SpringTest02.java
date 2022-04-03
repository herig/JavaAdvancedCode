package com.herig.week05.job02.spring02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringTest02 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
        Student student1 = (Student) applicationContext.getBean("student1");
        System.out.println(student1.toString());
    }
}
