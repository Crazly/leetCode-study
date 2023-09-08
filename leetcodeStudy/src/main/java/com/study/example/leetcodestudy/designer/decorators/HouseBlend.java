package com.study.example.leetcodestudy.designer.decorators;

public class HouseBlend extends Beverage {

    public HouseBlend() {
        System.out.println("综合咖啡：HouseBlend");
    }

    @Override
    public double cost() {
        return 0.99d;
    }
}
