package com.study.example.leetcodestudy.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkArrayListTest {

    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        List<String> linkList = new LinkedList<>();
        for (int i = 0; i < 10000; i++) {
            arrayList.add("0");
            linkList.add("0");
        }

        System.out.println(insertTime(arrayList));
        System.out.println(insertTime(linkList));


    }


    public static long insertTime(List<String> insertList){

        int num = 20000;
        int index = 2000;
        long l = System.currentTimeMillis();
        for (int i = 0; i < num; i++) {
            insertList.add(index,i+"");
        }
        return System.currentTimeMillis()-l;
    }

}
