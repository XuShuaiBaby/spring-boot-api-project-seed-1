package com.company.project.knowledge.demo;

import java.util.Date;
/**
 * 测试守护线程和用户线程的区别
 * @description
 * @author shuai.xu
 * @time 2019/9/19 16:31
*/
public class ThreadDemo {

    public static void main(String[] args) {
        //测试守护线程
        testDaemonThread();
        //测试用户线程
        //testUserThread();
        //主线程休眠5秒后退出
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("DaemonThreadTest.main()主线程退出");
    }

    public static void testDaemonThread(){
        DaemonThead t=new DaemonThead();
        Thread thread=new Thread(t);
        thread.setDaemon(true);//将当前线程设置为守护线程
        thread.start();//启动当前线程
    }

    public static void testUserThread(){
        UserThread u=new UserThread();
        Thread userThread=new Thread(u);
        userThread.setDaemon(false);//可不用设置，默认为用户线程
        userThread.start();
    }

}

class UserThread implements Runnable{

    @Override
    public void run() {
        String daemon = (Thread.currentThread().isDaemon() ? "daemon": "not daemon");
        while (true) {
            System.out.println("I'm running at " + new Date() + ", I am " + daemon);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("I was interrupt, I am " + daemon);
            }
        }
    }
}

class DaemonThead implements Runnable{

    @Override
    public void run() {
        String daemon = (Thread.currentThread().isDaemon() ? "daemon": "not daemon");
        while (true) {
            System.out.println("I'm running at " + new Date() + ", I am " + daemon);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("I was interrupt, I am " + daemon);
            }
        }
    }

}