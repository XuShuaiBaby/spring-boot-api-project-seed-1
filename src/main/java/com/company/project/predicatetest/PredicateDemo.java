package com.company.project.predicatetest;

import com.company.project.model.Goods;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateDemo {

    public static void main(String[] args) {
        int price = 10;
        List<Goods> goodsList = new ArrayList<>();
        Goods goods = new Goods(1,"苹果",10);
        Goods goods1 = new Goods(1,"香蕉",20);
        Goods goods2 = new Goods(1,"苹果",30);
        Goods goods3 = new Goods(1,"香蕉",40);
        goodsList.add(goods);
        goodsList.add(goods1);
        goodsList.add(goods2);
        goodsList.add(goods3);
        //filter(goodsList,(Goods g) -> g.getPrice() > 20).stream().forEach(System.out::println);
        goodsList
                .stream()
                .filter(goods4 -> goods4.getPrice() > 0)
                .filter(goods4 -> goods4.getName().equals("香蕉"))
                .peek(goods43 -> goods43.setPrice(goods43.getPrice() + 1))
                .peek(goods42 -> goods42.setPrice(goods42.getPrice() * 2))
                .forEach(System.out::println);
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> result = new ArrayList<>();
        for(T e: list){
            if(p.test(e)){
                result.add(e);
            }
        }
        return result;
    }

}
