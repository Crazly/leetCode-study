package com.study.example.leetcodestudy.designer.duckStudy;

public class MallardDuck extends Duck{


    public MallardDuck() {
        System.out.println("Mallard duck begin");
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    @Override
    void swim() {

    }

    @Override
    void display() {
        System.out.println("Mallard duck begin");
    }
}
