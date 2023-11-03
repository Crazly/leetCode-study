package com.study.example.leetcodestudy.test.other;

public class TestThreadJoin extends Thread{
        String local = "1314";
        int i;
        Thread previousThread;
        public TestThreadJoin(Thread previousThread,int i){
            this.previousThread=previousThread;
            this.i=i;
        }
        @Override
        public void run() {
            synchronized (local){
                long l = System.currentTimeMillis();
                try {
                    System.out.println("begin");
                    Thread.sleep(2000);
//                    previousThread.join(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long l1 = System.currentTimeMillis();
                System.out.println("end,num:"+i+":"+this.getName()+"waitTime:"+(l1 - l));
            }
        }
        public static void main(String[] args) throws InterruptedException {
            Thread previousThread=Thread.currentThread();
            for(int i=0;i<10;i++){
               TestThreadJoin joinDemo=new TestThreadJoin(previousThread,i);
                long l = System.currentTimeMillis();
                joinDemo.start();
//                joinDemo.join(100);
                previousThread=joinDemo;
                long l1 = System.currentTimeMillis();
                System.out.println("waitTime:"+(l1 - l));

            }
        }


}
