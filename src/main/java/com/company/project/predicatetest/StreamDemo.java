package com.company.project.predicatetest;

import com.company.project.model.Goods;
import com.company.project.model.Shop;

import java.util.ArrayList;
import java.util.List;

public class StreamDemo {
    static List<Shop> shopList =  new ArrayList<>();
    static {
        Shop shop = new Shop();
        List<Goods> goodsList = new ArrayList<>();
        Goods goods = new Goods(1,"苹果",10);
        Goods goods1 = new Goods(1,"香蕉",20);
        Goods goods2 = new Goods(1,"苹果",30);
        Goods goods3 = new Goods(1,"香蕉",40);
        goodsList.add(goods);
        goodsList.add(goods1);
        goodsList.add(goods2);
        goodsList.add(goods3);
        shop.setGoodsList(goodsList);
        shop.setName("万达水果店");
        Shop shop1 = new Shop();
        List<Goods> goodsList1 = new ArrayList<>();
        Goods goods4 = new Goods(1,"葡萄",10);
        Goods goods5 = new Goods(1,"梨",20);
        Goods goods6 = new Goods(1,"葡萄",30);
        Goods goods7 = new Goods(1,"梨",40);
        goodsList1.add(goods4);
        goodsList1.add(goods5);
        goodsList1.add(goods6);
        goodsList1.add(goods7);
        shop1.setGoodsList(goodsList1);
        shop1.setName("大悦城水果店");
        Shop shop2 = new Shop();
        List<Goods> goodsList2 = new ArrayList<>();
        Goods goods8 = new Goods(1,"菠萝",10);
        Goods goods9 = new Goods(1,"榴莲",20);
        Goods goods10 = new Goods(1,"榴莲",30);
        Goods goods11 = new Goods(1,"菠萝",40);
        goodsList2.add(goods8);
        goodsList2.add(goods9);
        goodsList2.add(goods10);
        goodsList2.add(goods11);
        shop2.setGoodsList(goodsList2);
        shop2.setName("环球港水果店");
        shopList.add(shop);
        shopList.add(shop1);
        shopList.add(shop2);
    }

    public static void main(String[] args) {
        List<String> nameList = new ArrayList<>();
        nameList.add("万达水果店");
        nameList.add("大悦城水果店");
        nameList.add("环球港水果店");
        shopList
                .stream()
                .flatMap(shop -> shop.getGoodsList().stream())
                .forEach(goods -> System.out.println(goods));
    }
}
