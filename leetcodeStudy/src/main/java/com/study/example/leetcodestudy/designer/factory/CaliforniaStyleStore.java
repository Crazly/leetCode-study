package com.study.example.leetcodestudy.designer.factory;

public class CaliforniaStyleStore extends PizzaStore{
    @Override
    public Pizza createPizza(String type) {

        if ("cheese".equals(type)) {
            return new CaliforniaStyleCheesePizza();
        } else if ("veggle".equals(type)) {
            new CaliforniaStyleCheesePizza();
        }else {
            return null;
        }
        return null;
    }
}
