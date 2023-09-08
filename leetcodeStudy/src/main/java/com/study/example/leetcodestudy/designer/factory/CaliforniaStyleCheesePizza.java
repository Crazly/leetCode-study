package com.study.example.leetcodestudy.designer.factory;

public class CaliforniaStyleCheesePizza extends Pizza{
    public CaliforniaStyleCheesePizza() {
        name="加州疯狂芝士披萨";
        dough="中等面团";
        sauce="意大利加州果酱";
        toppings.add("覆盖上一层石灰");
    }

    @Override
    void bake() {

    }

    @Override
    void cut() {

    }

    @Override
    void box() {
        System.out.println("需要装盒子");
    }
}
