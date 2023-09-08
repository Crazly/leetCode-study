package com.study.example.leetcodestudy.designer.factory;

public abstract class PizzaStore {
    public abstract Pizza createPizza(String type);


    public final Pizza orderPizza(String type){
        Pizza pizza;
        pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }



}
