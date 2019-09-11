package com.company.project.knowledge.proxy;

public class TestMain {

    public static void main(String[] args) {
        //真实角色.
        Animal dog=new Dog();
        //代理角色.
        //AnimalProxy proxyRole=new AnimalProxy(dog);
        Animal animal = (Animal) new AnimalProxyInvocation().getInstance(dog);
        //代替执行.
        animal.run();

        Car car = (Car) new CarProxy(new Car()).getProxyInstance();
        car.run();

    }

}
