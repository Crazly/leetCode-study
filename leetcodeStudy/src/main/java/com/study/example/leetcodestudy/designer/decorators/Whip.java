package com.study.example.leetcodestudy.designer.decorators;

public class Whip extends CondimentDecorator{

    Beverage beverage;


    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return 0.10+beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.description+"Whip";
    }
}
