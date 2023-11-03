package com.study.example.leetcodestudy.test.study03;

public class MyThreadTest {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
//        t1.run();
//        for (int i = 0; i <= 100; i++) {
//            if (i%2==0) {
//                System.out.println(Thread.currentThread().getName()+":"+i);
//            }
//        }


        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    if (i%2==0) {
                        System.out.println(Thread.currentThread().getName()+":"+i);
                    }
                }
            }
        }.start();

    }


}
class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i%2==0) {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
//        super.run();
    }
}
