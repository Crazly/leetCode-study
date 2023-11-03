package com.study.example.leetcodestudy.bean;

public class Test2 {
    static int x,y,z;
    static {
        int x = 5;
        x--;
    }
static {
        x--;
}

public static void method(){
        y=z++ + ++z;
}

    public static void main(String[] args) {
        System.out.println("x="+x);//-1
        z--;//-1
        method();//y=-1+1=0
        System.out.println("result="+(x+y+ ++z));//-1+0+2=0

    }

}
