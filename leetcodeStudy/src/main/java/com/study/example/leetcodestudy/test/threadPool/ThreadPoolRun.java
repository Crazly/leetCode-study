package com.study.example.leetcodestudy.test.threadPool;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class ThreadPoolRun {

    List<ThreadPoolTask> threadPoolTasks = new ArrayList<>();

    public void initThreadPoolTask(){

        threadPoolTasks.add(new ThreadPoolTask("task1"));
        threadPoolTasks.add(new ThreadPoolTask("task2"));

        for (final ThreadPoolTask threadPoolTask : threadPoolTasks) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    threadPoolTask.doExecute();
                }
            }).start();

        }

    }
    //停止
    public void shutDownThread(){
        if (!CollectionUtils.isEmpty(threadPoolTasks)) {
            for (ThreadPoolTask threadPoolTask : threadPoolTasks) {
                threadPoolTask.terminal();
            }
        }

}

    public static void main(String[] args) throws Exception{

        ThreadPoolRun poolRun = new ThreadPoolRun();
        poolRun.initThreadPoolTask();
        Thread.sleep(5000l);
        poolRun.shutDownThread();
    }


}
