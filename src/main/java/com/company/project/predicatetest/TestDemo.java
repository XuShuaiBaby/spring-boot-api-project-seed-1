package com.company.project.predicatetest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestDemo {

    public static void main(String[] args) {
        Map<String,String> pd1=new HashMap<>();
        pd1.put("name","小明");
        pd1.put("age","18");
        pd1.put("sex","男");

        Map<String,String> pd2=new HashMap<>();
        pd2.put("name","小红");
        pd2.put("age","20");
        pd2.put("sex","女");
        //[{sex=男, name=小明, age=18}, {sex=女, name=小红, age=20}]
        //[{ name=小明, age=18}, { name=小红, age=20}]
        List<Map<String,String>> list=new ArrayList();

        list.add(pd1);
        list.add(pd2);

        System.out.println(list);
        String[] keys = {"age","sex"};

        list.stream().forEach(stringStringMap -> { for (int i = 0; i <keys.length ; i++) { stringStringMap.remove(keys[i]); } });
        System.out.println(list);

    }
}
