package com.herig.week05.job02.spring03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest03 {


    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
        Klass klass = (Klass)applicationContext.getBean("createKlass");
        Student student1 = (Student)applicationContext.getBean("student1");
        System.out.println(klass.toString());
        System.out.println(student1.toString());




    }
}
