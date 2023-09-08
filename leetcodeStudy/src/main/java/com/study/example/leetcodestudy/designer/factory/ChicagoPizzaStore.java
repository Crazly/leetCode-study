package com.study.example.leetcodestudy.designer.factory;

public class ChicagoPizzaStore extends PizzaStore{
    @Override
    public Pizza createPizza(String type) {
        if ("cheese".equals(type)) {
            return new ChicagoStyleCheesePizza();
        }

        return new NYStylePizza();
    }
}
