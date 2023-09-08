package com.study.example.leetcodestudy.designer.decorators;

public class Decaf extends Beverage {

    public Decaf() {
        System.out.println("低咖啡：Decaf");
    }

    @Override
    public double cost() {
        return 1.05d;
    }
}
