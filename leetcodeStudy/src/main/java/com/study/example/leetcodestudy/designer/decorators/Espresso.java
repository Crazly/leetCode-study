package com.study.example.leetcodestudy.designer.decorators;

public class Espresso extends Beverage {

    public Espresso() {
        System.out.println("浓缩咖啡：Espresso");
    }

    @Override
    public double cost() {
        return 1.99d;
    }
}
