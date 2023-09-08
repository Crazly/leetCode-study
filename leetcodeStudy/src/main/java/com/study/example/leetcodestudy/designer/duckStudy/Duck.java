package com.study.example.leetcodestudy.designer.duckStudy;

public abstract class Duck {

    FlyBehavior flyBehavior;

    QuackBehavior quackBehavior;

    abstract void swim();
     abstract void display();


     void performFly(){
         flyBehavior.fly();
     }
    void performQuack(){
         quackBehavior.quack();
    }

    void setFlyBehavior(FlyBehavior fb){
         this.flyBehavior=fb;
    }

    void setQuackBehavior(QuackBehavior qb){
         this.quackBehavior = qb;
    }

}
