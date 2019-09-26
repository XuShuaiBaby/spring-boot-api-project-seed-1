package com.company.project.knowledge.demo;

import com.google.common.collect.Sets;

import java.util.Random;
import java.util.Set;

public class ListDemo {

    static Set<Integer> set = Sets.newHashSet(1,2,3,4,5);
    static Set<Integer> set1 = Sets.newHashSet(1,4,5);

    public static void main(String[] args) {
        System.out.println(set.containsAll(set1));
        System.out.println(new Random().nextInt(10000));
    }

}
