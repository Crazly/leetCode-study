package com.study.example.leetcodestudy.bean;

import com.study.example.leetcodestudy.aspect.IPowerService;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Study extends Person implements IPowerService {

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

    @Override
    public void talk(){
        System.out.println("学习说人话");
    }

    public void speech(){
        System.out.println("study speech");
    }

    @Override
    public boolean login(String userName, String password) {
        return false;
    }
}
