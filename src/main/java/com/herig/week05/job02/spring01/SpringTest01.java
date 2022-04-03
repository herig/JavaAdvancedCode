package com.herig.week05.job02.spring01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest01 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext01.xml");
        Student student1 = (Student)applicationContext.getBean("student1");
        Student student2 = (Student)applicationContext.getBean("student2");

        Student student3 = new Student();
        student3.setId(3);
        student3.setName("王五");
        student3.setAge(18);

        System.out.println(student1.toString());
        System.out.println(student2.toString());
        System.out.println(student3.toString());

    }
}
