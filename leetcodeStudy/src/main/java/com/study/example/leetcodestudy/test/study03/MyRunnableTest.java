package com.study.example.leetcodestudy.test.study03;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class MyRunnableTest {
    public static void main(String[] args) {
//
//        MyRunnable run1 = new MyRunnable();
//        new Thread(run1).start();
////        new Thread()
//        for (int i = 0; i <= 100; i++) {
//            System.out.println(Thread.currentThread().getName()+":"+i);
//        }
        String str = "[{bizType:1,shopCode:1004,shopName:上海龙阳店},{bizType:1,shopCode:1003,shopName:上海杨浦店},{bizType:1,shopCode:9103,shopName:上海普陀店},{bizType:0,shopCode:9102,shopName:上海梅陇店},{bizType:0,shopCode:1001,shopName:上海沪太店},{bizType:0,shopCode:1009,shopName:上海徐泾店},{bizType:0,shopCode:1005,shopName:上海闵行店},{bizType:0,shopCode:1302,shopName:深圳南山店},{bizType:0,shopCode:1010,shopName:上海莘庄店},{bizType:0,shopCode:9101,shopName:上海闸北店},{bizType:0,shopCode:9104,shopName:上海金桥店},{bizType:0,shopCode:1301,shopName:深圳罗湖店},{bizType:0,shopCode:1303,shopName:深圳泰然店},{bizType:0,shopCode:1306,shopName:深圳西丽店},{bizType:1,shopCode:H001,shopName:深圳欧洲城店},{bizType:1,shopCode:H002,shopName:深圳又一居店}]";
        String jsonString = JSONObject.toJSONString(str);
        System.out.println(jsonString);

    }

}

class MyRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
