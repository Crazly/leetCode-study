package com.study.example.leetcodestudy.bean;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Study {

    private String name;
    private Integer age;
    private Integer number;

    public Study() {
    }

    public Study(String name, Integer age, Integer number) {
        this.name = name;
        this.age = age;
        this.number = number;
    }
}
