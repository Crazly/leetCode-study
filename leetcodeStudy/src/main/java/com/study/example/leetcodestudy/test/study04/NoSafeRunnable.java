package com.study.example.leetcodestudy.test.study04;

public class NoSafeRunnable implements Runnable{
    private Integer num =100;
    @Override
    public void run() {
            while (true){
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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

class NoSafeRunnableTest {

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
