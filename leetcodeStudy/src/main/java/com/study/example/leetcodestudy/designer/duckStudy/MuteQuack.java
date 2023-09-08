package com.study.example.leetcodestudy.designer.duckStudy;

public class MuteQuack extends Duck implements QuackBehavior{
    @Override
    void swim() {

    }

    @Override
    void display() {

    }

    @Override
    public void quack() {
        System.out.println("我就是不叫");
    }
}
