package com.company.project.web;

import com.company.project.model.Goods;
import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoodsTest{

    public static void main(String[]args){
        List<Goods> list = new ArrayList<>();
        Goods goods = new Goods(1,"苹果",20);
        Goods goods1 = new Goods(1,"苹果",18);
        Goods goods2 = new Goods(1,"香蕉",20);
        Goods goods3 = new Goods(1,"香蕉",18);
        list.add(goods);
        list.add(goods1);
        list.add(goods2);
        list.add(goods3);
        Map<String,Integer> map = new HashMap<>();
        list.forEach(e->{
            if (map.containsKey(e.getName())&&map.get(e.getName()).compareTo(e.getPrice())!=0){
                System.out.println(e.getName()+"价格不同");
            }
            if (!map.containsKey(e.getName())){
                map.put(e.getName(),e.getPrice());
            }
        });
    }
}
