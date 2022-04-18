package com.study.example.leetcodestudy.test;

import com.alibaba.fastjson.JSONObject;

import javax.print.attribute.standard.Destination;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parcel5 {

    public static void main(String[] args) {

        try {

            List<String> num = new ArrayList<>();
            num.add("a");
            num.add("b");
            num.add("c");
            num.add("d");
            num.add("e");

            List<String> strings = num.subList(0, num.size());
            System.out.println(JSONObject.toJSONString(strings));

            Map<Integer,Integer> map = new HashMap<>();

            Class<?> hashMap = Class.forName("HashMap");
            Constructor<?> constructor = hashMap.getConstructor();
            Map<Integer, Integer> integerIntegerMap = (Map<Integer, Integer>) constructor.newInstance();



        }catch (Exception e){

            System.out.println("error :"+e);
        }


    }

}
