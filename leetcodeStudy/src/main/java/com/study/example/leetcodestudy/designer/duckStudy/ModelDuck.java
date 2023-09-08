package com.study.example.leetcodestudy.designer.duckStudy;

public class ModelDuck extends Duck{


    public ModelDuck() {
        System.out.println("ModelDuck begin");
        flyBehavior = new FlyNoWay();
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
