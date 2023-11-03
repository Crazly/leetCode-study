package com.study.example.leetcodestudy.test.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingleStudy {

    private volatile static SingleStudy singleStudy;

    private SingleStudy() {
    }

    public static SingleStudy getSingleStudyTest(){

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
//        for (String arg : args) {
//            System.out.println("hello"+arg);
//        }
//        Map<String,String> testMap = new HashMap<>();
//        testMap.put("5762","1234");
//        testMap.put("5763","1234");
//        testMap.put("5764","1234");
//        Long s = 5762l;
//        if (testMap.containsKey(s+"")) {
//            System.out.println("true");
//        }else {
//            System.out.println("false");
//        }
//        String supplierCode = "D673";
//        supplierCode = supplierCode.replaceFirst("^0*", "");
//        System.out.println(supplierCode);
//        System.out.println(5/2);
        String name = "123456789";
        Integer age =20;
        //将name和age生成到一个PDF文件中
        List<String> list = new ArrayList<>();
        list.add(name);
        list.add(age+"");
        System.out.println(list);
        //使用java代码生成一个PDF文件，并将name和age生成到一个PDF文件中

    }

}







