package com.study.example.leetcodestudy.designer.factory;

public class NYPizzaStore extends PizzaStore{
    @Override
    public Pizza createPizza(String type) {
        if ("cheese".equals(type)) {
            return new NYStyleCheesePizza();
        }

        return new NYStylePizza();
    }
}
