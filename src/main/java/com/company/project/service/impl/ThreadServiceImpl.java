package com.company.project.service.impl;

import com.company.project.service.ThreadDemoService;
import org.springframework.stereotype.Service;

import static com.company.project.knowledge.demo.ThreadDemo.testDaemonThread;
import static com.company.project.knowledge.demo.ThreadDemo.testUserThread;

@Service
public class ThreadServiceImpl implements ThreadDemoService {
    @Override
    public void strat() {
        System.out.println("进来了");
        //测试守护线程
        //testDaemonThread();
        //测试用户线程
        testUserThread();
        //主线程休眠5秒后退出
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("DaemonThreadTest.main()主线程退出");
    }
}
