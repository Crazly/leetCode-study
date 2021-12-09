import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class testD {
    private static Object resource1 = new Object();//资源 1
    private static Object resource2 = new Object();//资源 2

    private AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void lock(){
        Thread thread = Thread.currentThread();
        //自旋等待
        while (!atomicReference.compareAndSet(null, thread)) {

        }
    }

    public void unlock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread,null);

    }

    static int count=0;

    public static void main(String[] args) throws InterruptedException {

//        List<String> s1 = new ArrayList<>();
//        if (s1.contains("1")) {
//            System.out.println("111");
//        }else {
//            System.out.println("222");
//        }
        testD t = new testD();
        List<Thread> threads = new ArrayList<>();
        for (int i=0;i<100;i++){

            Thread thread = new Thread(()->{
                t.lock();
                for (int j =0;j<100;j++){
                    count++;
                }
                t.unlock();
            });
            thread.start();
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println(count);
        System.gc();
//
//        new Thread(()->{
//
//            synchronized(resource1){
//                System.out.println(Thread.currentThread()+"get resource1");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("wait get resource2");
//                synchronized (resource2){
//                    System.out.println(Thread.currentThread()+"get resource2");
//                }
//            }
//
//        }).start();



    }
}
