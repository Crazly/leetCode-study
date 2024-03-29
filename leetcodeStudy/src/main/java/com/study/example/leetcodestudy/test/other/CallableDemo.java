package com.study.example.leetcodestudy.test.other;

import com.study.example.leetcodestudy.bean.Study;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CallableDemo{


//    new ThreadPoolExecutor(5,5,0l,TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>(10),new ThreadFactoryBuilder);

//    public static void main(String[] args){
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        List<Future<String>> resultList = new ArrayList<Future<String>>();
//
//        //创建10个任务并执行
//        for (int i = 0; i < 10; i++){
//            //使用ExecutorService执行Callable类型的任务，并将结果保存在future变量中
//            Future<String> future = executorService.submit(new TaskWithResult(i));
//            //将任务执行结果存储到List中
//            resultList.add(future);
//        }
//
//        //遍历任务的结果
//        for (Future<String> fs : resultList){
//            try{
//                while(!fs.isDone());//Future返回如果没有完成，则一直循环等待，直到Future返回完成
//                System.out.println(fs.get());     //打印各个线程（任务）执行的结果
//            }catch(InterruptedException e){
//                e.printStackTrace();
//            }catch(ExecutionException e){
//                e.printStackTrace();
//            }finally{
//                //启动一次顺序关闭，执行以前提交的任务，但不接受新任务
//                executorService.shutdown();
//            }
//        }
//    }

    public static void main(String[] args) {

        Study study = new Study();
        try {
            Class<?> study1 = Class.forName("com.study.example.leetcodestudy.bean.Study");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Class<Study> studyClass = Study.class;
        try {
            Study study1 = studyClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


//        MyThread thread1 = new MyThread();
//        FutureTask<String> future = new FutureTask<>(thread1);
//        new Thread(future,"test").start();
//        try {
//            String s = future.get();
//            System.out.println("线程输出："+s);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
//        list.parallelStream().skip(a * splitSize).limit(splitSize).collect(Collectors.toList())

        List<List<Integer>> collect1 = Stream.iterate(0,n -> ++n)
                .limit(3)
                .parallel()
                .map(a -> list.parallelStream().skip(a * 3).limit(3).collect(Collectors.toList()))
                .filter(c -> !c.isEmpty())
                .collect(Collectors.toList());
//        List<Integer> collect = list.parallelStream().skip(1 * 3).limit(3).collect(Collectors.toList());
        System.out.println(collect1);
    }
}

class MyThread implements Callable<String>{

    @Override
    public String call() throws Exception {
        return "call 有返回值";
    }
}

class MyThreadStudy implements Callable<Study>{

    @Override
    public Study call() throws Exception {
        Study s = new Study();
        s.setName("yjc");
        s.setAge(22);
        s.setNumber(1314);
        return s;
    }
}


class TaskWithResult implements Callable<String>{
    private int id;

    public TaskWithResult(int id){
        this.id = id;
    }

    /**
     * 任务的具体过程，一旦任务传给ExecutorService的submit方法，
     * 则该方法自动在一个线程上执行
     */
    public String call() throws Exception {
        System.out.println("call()方法被自动调用！！！    " + Thread.currentThread().getName());
        //该返回结果将被Future的get方法得到
        return "call()方法被自动调用，任务返回的结果是：" + id + "    " + Thread.currentThread().getName();
    }
}