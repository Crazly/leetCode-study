package com.study.example.leetcodestudy.designer.decorators.inputIOTest;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class InputStreamTest {


    public static void main(String[] args) {
//        try {
//            int c;
//            InputStream inputStream = new LowerCasetInputstream(new BufferedInputStream(new FileInputStream("/Users/yangjc/Desktop/test.txt")));
//
//            while ((c=inputStream.read())>=0){
//                System.out.println((char)c);
//            }
//        inputStream.close();
//        }catch (Exception e){
//            System.out.println(e);
//        }
        Map<String,String> addTestMap = new HashMap<>();
        String s = addTestMap.putIfAbsent("s", "s");
        System.out.println(s);
        if (null==s) {
            System.out.println("sssssssss");
        }
        String s1 = addTestMap.putIfAbsent("s", "a");
        System.out.println(s1);


    }

}
