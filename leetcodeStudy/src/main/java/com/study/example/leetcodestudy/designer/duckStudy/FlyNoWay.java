package com.study.example.leetcodestudy.designer.duckStudy;

public class FlyNoWay extends Duck implements FlyBehavior{
    @Override
    void swim() {

    }

    @Override
    void display() {

    }

    @Override
    public void fly() {
        System.out.println("不会飞");
    }
}
