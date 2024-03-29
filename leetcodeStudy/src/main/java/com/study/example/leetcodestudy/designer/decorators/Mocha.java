package com.study.example.leetcodestudy.designer.decorators;

public class Mocha extends CondimentDecorator{

    Beverage beverage;


    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return 0.20+beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.description+"Mocha";
    }
}
