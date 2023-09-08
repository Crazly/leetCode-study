package com.study.example.leetcodestudy.spring;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public class SpringTestForMe {


    static int a=0,x=0;
    static int b=0,y=0;
    public static void main(String[] args) {
        try {
//            Map<String, String> getenv = System.getenv();
//            System.out.println(JSONObject.toJSONString(getenv));
//            Class<?> aClass = Class.forName("com.study.example.leetcodestudy.bean.Study");
//            Class<Study> studyClass = Study.class;
//            Study study = studyClass.newInstance();
//
//            Field[] fields = studyClass.getFields();
//            List<String> collect = Arrays.stream(fields).map(Field::getName).collect(Collectors.toList());
//            System.out.println(JSONObject.toJSONString(collect));


            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    a=1;
                    x=b;
                }
            });

            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    b=1;
                    y=a;
                }
            });

            t1.start();
            t2.start();
            t1.join();
            t2.join();
            System.out.println("a="+a+"   b="+b);

        }catch (Exception e){
            System.out.println(e);
        }

    }


}
