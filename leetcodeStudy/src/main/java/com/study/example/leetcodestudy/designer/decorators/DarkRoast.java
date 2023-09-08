package com.study.example.leetcodestudy.designer.decorators;

public class DarkRoast extends Beverage {

    public DarkRoast() {
        System.out.println("深烘培咖啡：DarkRoast");
    }

    @Override
    public double cost() {
        return 0.99d;
    }
}
