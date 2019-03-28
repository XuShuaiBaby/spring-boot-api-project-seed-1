package com.company.project.knowledge.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class AnimalProxyInvocation implements InvocationHandler {

    private Animal animal;

    public Object getInstance(Animal animal){
        this.animal = animal;
        Class clazz = animal.getClass();
        Object obj = Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
        return obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //        System.out.println(proxy+"  "+method+" "+ args.toString());
        System.out.println("name："+proxy.getClass().getName());
        System.out.println(method+"  "+ Arrays.toString(args));//传入的参数类型
        long start=System.nanoTime();
        System.out.println("调用之前.......");
        //Object result=ms.get(method.getName()).invoke(target,args);
        Object result=method.invoke(animal,args);
        System.out.println(result);
        long cost=System.nanoTime()-start;
        System.out.println("调用之后，"+method.getName()+" 耗时： "+cost+" ns");

        return result;
    }
}
