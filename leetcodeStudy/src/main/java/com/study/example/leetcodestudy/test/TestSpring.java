package com.study.example.leetcodestudy.test;

import com.study.example.leetcodestudy.bean.TestSpringService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:test-spring.xml");
        System.out.println("context started!");
        TestSpringService messageService = (TestSpringService) context.getBean("messageService");
        TestSpringService bean = context.getBean(TestSpringService.class);
        System.out.println(messageService.getMessage());
        System.out.println(bean.getMessage());

    }
}
