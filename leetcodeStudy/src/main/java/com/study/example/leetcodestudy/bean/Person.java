package com.study.example.leetcodestudy.bean;


public abstract class Person {
    String name;
    Integer age;

    public void talk(){
        System.out.println("人说话");
    }
    public void walk(){
        System.out.println("人走路");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
