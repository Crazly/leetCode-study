package com.study.example.leetcodestudy.test.study01;

import com.study.example.leetcodestudy.test.study02.MyAnnotation;

@MyAnnotation("s")
public class Chinese implements Eatable{
    @MyAnnotation("sw")
    private String sss;


    @MyAnnotation("ss")
    @Override
    public void eat() {
        System.out.println("用筷子吃饭");
    }
}
