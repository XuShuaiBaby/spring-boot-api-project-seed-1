package com.company.project.knowledge.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CarProxy implements MethodInterceptor {

    private Car target;

    public CarProxy(Car target) {
        this.target = target;
    }

    public Object getProxyInstance(){
    //1.工具类
     Enhancer en = new Enhancer();
     //2.设置父类
     en.setSuperclass(target.getClass());
     //3.设置回调函数
     en.setCallback(this);
     //4.创建子类(代理对象)
     return en.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("汽车准备发动了");
        Object returnValue = method.invoke(target,objects);
        System.out.println("汽车停了下来");
        return returnValue;
    }
}
