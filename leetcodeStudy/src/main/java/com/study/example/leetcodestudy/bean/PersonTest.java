package com.study.example.leetcodestudy.bean;

import com.study.example.leetcodestudy.aspect.IPowerService;

public class PersonTest {


    public static void main(String[] args) {

//        String fileName = "1421910/12222/1421910-1.png";
//        String fileName = "1421910";
//        String[] split = fileName.split("\\.");
//        String filePath = split[0];
//        int i = filePath.lastIndexOf("/");
//        if (-1==i) {
//            System.out.println(filePath);
//        }else {
//            System.out.println(filePath.substring(i+1));
//
////            System.out.println(filePath.substring(0, i));
//        }
       stet stet = new stet();
        System.out.println(stet.i);

        Person s = new Study();
        s.talk();

        IPowerService ss = new Study();
        boolean bool =  ss.login("yangchao", "123");
        System.out.println(bool);
    }


}
class stet{

    int i =1;

    {
        i=2;
    }

}

