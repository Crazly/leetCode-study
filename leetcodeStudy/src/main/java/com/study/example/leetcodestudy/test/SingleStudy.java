package com.study.example.leetcodestudy.test;

import java.util.HashMap;
import java.util.Map;

public class SingleStudy {

    private volatile static SingleStudy singleStudy;

    public SingleStudy() {
    }

    public SingleStudy getSingleStudyTest(){

        if (null==singleStudy) {
            synchronized (SingleStudy.class){
                if (null==singleStudy) {
                    singleStudy = new SingleStudy();
                }
            }
        }
        return singleStudy;
    }

    public static void main(String[] args) {

        Map<String,String> testMap = new HashMap<>();
        testMap.put("5762","1234");
        testMap.put("5763","1234");
        testMap.put("5764","1234");
        Long s = 5762l;
        if (testMap.containsKey(s+"")) {
            System.out.println("true");
        }else {
            System.out.println("false");
        }

    }


}
