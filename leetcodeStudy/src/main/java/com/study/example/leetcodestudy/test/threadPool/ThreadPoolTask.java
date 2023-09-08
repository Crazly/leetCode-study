package com.study.example.leetcodestudy.test.threadPool;

import com.google.common.collect.Lists;
import com.study.example.leetcodestudy.bean.Study;
import com.study.example.leetcodestudy.util.ThreadPoolUtil;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

public class ThreadPoolTask {
    private final int poolSize = 2;
    private final int splitData = 4;//数据分割份数

    private String taskName;

    protected volatile boolean shutDownFlag = false;//jvm是否关闭

    public ThreadPoolTask(String taskName) {
        this.taskName = taskName;
    }


    //任务执行入口
    public void doExecute(){
        int i=0;
        while (true){
            System.out.println(taskName+"num-"+i+"-begin");
            //获取数据
            List<Study> data = queryData();
            //处理数据
            taskExecute(data);
            System.out.println(taskName+"num-"+i+"-end");
            //结束任务
            if (shutDownFlag) {
                break;
            }
        }
        //回收线程
        ThreadPoolUtil.releaseThreadPool(taskName);
    }

    private void taskExecute(List<Study> data) {
        if (CollectionUtils.isEmpty(data)) {
            return;
        }
        //数据分割
        List<List<Study>> partition = Lists.partition(data, splitData);
        //允许多线程同时处理
        final CountDownLatch countDownLatch = new CountDownLatch(partition.size());
        for (final List<Study> studies : partition) {
            ExecutorService treadPool = ThreadPoolUtil.getTreadPool(taskName, poolSize);

            treadPool.submit(new Runnable() {
                @Override
                public void run() {
                    //数据处理
                    doExecuteData(studies,countDownLatch);
                }
            });

        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            System.out.println(e.getStackTrace());
        }


    }

    private void doExecuteData(List<Study> studies, CountDownLatch countDownLatch) {
        try {
            for (Study study : studies) {
                System.out.println(study.getName()+"ThreadName:"+Thread.currentThread().getName());
                Thread.sleep(1000L);
            }
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }finally {
            if (countDownLatch!=null) {
                countDownLatch.countDown();
            }
        }
    }

    // 获取永动任务数据
    private List<Study> queryData() {
        List<Study> datas = new ArrayList<>();
        for (int i = 0; i < 5; i ++) {
            Study study = new Study();
            study.setName("罗小黑" + i);
            datas.add(study);
        }
        return datas;
    }
    // 优雅停机
    public void terminal() {
        // 关机
        shutDownFlag = true;
        System.out.println(taskName + " shut down");
    }
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}
