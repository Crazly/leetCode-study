package com.study.example.leetcodestudy.test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平锁非公平锁测试
 */
@Slf4j(topic = "c.TestFair")
public class TestFair implements Runnable {

    private ReentrantLock reentrantLock;  //锁
    private static Integer num = 0;

    public TestFair(ReentrantLock reentrantLock){
        this.reentrantLock = reentrantLock;
    }

    @Override
    public void run() {
        while (true){
            reentrantLock.lock();
            try {
                num ++;
                log.debug(Thread.currentThread().getName() + num);
            }finally {
                reentrantLock.unlock();
            }

        }
    }

    public static void main(String[] args) {

        //公平锁
//        ReentrantLock fair = new ReentrantLock(true);
//        new Thread(new TestFair(fair),"t1").start();
//        new Thread(new TestFair(fair),"t2").start();

        //不公平锁
        ReentrantLock unFair = new ReentrantLock(false);
        new Thread(new TestFair(unFair),"t1").start();
        new Thread(new TestFair(unFair),"t2").start();
    }
}
