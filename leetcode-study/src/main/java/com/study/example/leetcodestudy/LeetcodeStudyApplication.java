package com.study.example.leetcodestudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class LeetcodeStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeetcodeStudyApplication.class, args);
    }

}
