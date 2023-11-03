package com.study.example.leetcodestudy.test.study04;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest {


}

class NoSafeRunnabled implements Runnable{
    private Integer num =100;
    private ReentrantLock reentrantLock = new ReentrantLock();
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            notify();
            synchronized (NoSafeRunnable.class){
                if(num > 0){
                    System.out.println(Thread.currentThread().getName()+"买票:"+num);
                    num--;
                }else{
                    break;
                }
            }
        }
    }
}

class NoSafeRunnabledTest {

    public static void main(String[] args) {
        NoSafeRunnable r = new NoSafeRunnable();
//        NoSafeRunnable r2 = new NoSafeRunnable();

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();

    }

}
