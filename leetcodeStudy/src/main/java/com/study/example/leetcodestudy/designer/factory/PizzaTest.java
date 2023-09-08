package com.study.example.leetcodestudy.designer.factory;

public class PizzaTest {

    public static void main(String[] args) {

        NYPizzaStore nyPizzaStore = new NYPizzaStore();
        Pizza pizza = nyPizzaStore.orderPizza("cheese");

        ChicagoPizzaStore chicagoPizzaStore = new ChicagoPizzaStore();

        Pizza pizza1 = chicagoPizzaStore.orderPizza("cheese");

        CaliforniaStyleStore californiaStyleStore = new CaliforniaStyleStore();
        Pizza cheese = californiaStyleStore.orderPizza("cheese");

    }
}
