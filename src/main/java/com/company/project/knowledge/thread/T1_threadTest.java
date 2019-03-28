package com.company.project.knowledge.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * 多线程共享数据情况
* @description
* @author shuai.xu
* @time 2019/1/18 15:47
*/
public class T1_threadTest implements Runnable{

    private int count = 5;

    @Override
    //synchronized 加锁情况下 线程同步
    public void run() {
        while (count > 0) {
            count--;
            System.out.println("由 " + ThreadTest.currentThread().getName() + " 计算，count=" + count);
        }
    }

    public static void main(String[] args) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200,
                TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(5),namedThreadFactory);

            T1_threadTest threadTest = new T1_threadTest();
            executor.execute(threadTest);
            executor.execute(threadTest);
            System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
                    executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());
        executor.shutdown();
    }
}
