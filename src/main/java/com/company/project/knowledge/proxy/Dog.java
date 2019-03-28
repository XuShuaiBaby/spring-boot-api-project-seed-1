package com.company.project.knowledge.proxy;

public class Dog implements Animal{
    @Override
    public String run() {
        System.out.println("小狗跑------");
        return "小狗跑------";
    }
}
