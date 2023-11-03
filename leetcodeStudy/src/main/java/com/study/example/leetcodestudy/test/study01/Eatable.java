package com.study.example.leetcodestudy.test.study01;

public interface Eatable {

    public abstract void eat();

    public static void sub(){
        System.out.println("sssss");
    }

    default void talk(){

    }
}
