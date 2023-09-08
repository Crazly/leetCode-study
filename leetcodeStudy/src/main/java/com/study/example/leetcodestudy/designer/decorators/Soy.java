package com.study.example.leetcodestudy.designer.decorators;

public class Soy extends CondimentDecorator{

    Beverage beverage;


    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return 0.30+beverage.cost();
    }


    @Override
    public String getDescription() {
        return beverage.description+"Soy";
    }
}
