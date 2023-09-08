package com.study.example.leetcodestudy.designer.decorators;

public abstract class Beverage {
    public String description="不清楚的饮料";
    public abstract double cost();

    public String getDescription() {
        return description;
    }
}
