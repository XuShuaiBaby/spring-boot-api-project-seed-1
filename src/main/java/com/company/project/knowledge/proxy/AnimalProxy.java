package com.company.project.knowledge.proxy;

public class AnimalProxy implements Animal{

    private Animal animal;

    public AnimalProxy(Animal animal) {
        this.animal = animal;
    }

    @Override
    public String run() {
        System.out.println(" before execute......  ");
        String result=animal.run();
        System.out.println(result);
        System.out.println(" after execute......  ");
        return result;
    }
}
