package com.study.example.leetcodestudy.designer.duckStudy;

public class DuckTest {

    public static void main(String[] args) {

        Duck duck = new MallardDuck();
        duck.performQuack();
        duck.performFly();

        Duck modelDuck =new ModelDuck();
        modelDuck.performFly();
        modelDuck.setFlyBehavior(new FlyWithRocket());
        modelDuck.performFly();


    }


}
