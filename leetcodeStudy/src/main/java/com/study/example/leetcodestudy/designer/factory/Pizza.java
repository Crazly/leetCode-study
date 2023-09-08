package com.study.example.leetcodestudy.designer.factory;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {
    String name;
    String dough;
    String sauce;
    List toppings = new ArrayList();

     void prepare(){
         System.out.println("准备："+name);
         System.out.println("Tossing dough...");
         System.out.println("Add Sauce ...");
         System.out.println("Add toppings:");

         for (int i = 0; i < toppings.size(); i++) {
             System.out.println("步骤："+toppings.get(i));
         }
     };
    abstract void bake();
    abstract void cut();
    abstract void box();

    public String getName() {
        return name;
    }
}
