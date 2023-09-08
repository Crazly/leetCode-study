package com.study.example.leetcodestudy.util;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池工具
 */
public class ThreadPoolUtil {

    //任务本身的线程池
    private static Map<String, ExecutorService> executors = new HashMap<>();

    //初始化线程池
    private static ExecutorService initThreadPool(String poolName,int poolSize){

        return new ThreadPoolExecutor(poolSize,poolSize,0L,TimeUnit.MILLISECONDS,new LinkedBlockingDeque<Runnable>(),
                new ThreadFactoryBuilder().setNameFormat("pool-"+poolName).setDaemon(false).build(),new ThreadPoolExecutor.CallerRunsPolicy());
    }
    //获取线程池
    public static ExecutorService getTreadPool(String poolName,int poolSize){
        ExecutorService executorService = executors.get(poolName);
        if (executorService==null) {
            synchronized (ThreadPoolUtil.class){
                if (executorService==null) {
                     executorService = initThreadPool(poolName, poolSize);
                    executors.put(poolName,executorService);
                }
            }
        }
        return executorService;
    }
    //回收线程池
    public static void releaseThreadPool(String poolName){

        ExecutorService executorService = executors.remove(poolName);
        if (null!=executorService) {
            executorService.shutdown();
        }

    }


}
