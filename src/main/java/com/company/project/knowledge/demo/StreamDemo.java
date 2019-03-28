package com.company.project.knowledge.demo;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Stream api demo
* @description
* @author shuai.xu
* @time 2019/1/22 15:17
*/
public class StreamDemo {

    public static void main(String[] args) {
        List<Person> personList = init();
        //stream groupingBy 对数据进行分组
        Map<String, Map<String, List<Person>>> collect = personList.stream().collect(Collectors.groupingBy(Person::getCountry, Collectors.groupingBy(Person::getCity)));
        //stream filter 对数据进行过滤
        //List<Person> collect = personList.stream().filter(person -> "中国".equals(person.getCountry())).collect(Collectors.toList());
        //List<String> collect = personList.stream().map(person -> person.getName()).collect(Collectors.toList());
        String jsonString = JSON.toJSONString(collect);
        System.out.println(jsonString);
        String s = "926";
        String[] split = s.split(",");
        System.out.println(split.length);
        String s1 = "0033TH20190327SQ3Q";
        int index = Integer.parseInt(s1.substring(14))+1;
    }

    public static List<Person> init(){
        List<Person> list = new ArrayList();
        Person person1 = new Person("中国","上海","许帅",23);
        Person person2 = new Person("美国","纽约","周开顺",22);
        Person person3 = new Person("英国","伦敦","薛丑丑",20);
        Person person4 = new Person("中国","上海","大头",22);
        Person person5 = new Person("美国","纽约","合合",24);
        Person person6 = new Person("英国","伦敦","想哥",24);
        Person person7 = new Person("中国","合肥","小蒙蒙",18);
        Person person8 = new Person("中国","北京","pizza",2);
        list.add(person1);
        list.add(person2);
        list.add(person3);
        list.add(person4);
        list.add(person5);
        list.add(person6);
        list.add(person7);
        list.add(person8);
        return list;
    }
}

class Person{
    private String country;

    private String city;

    private String name;

    private Integer age;

    public Person() {

    }

    public Person(String country, String city, String name, Integer age) {
        this.country = country;
        this.city = city;
        this.name = name;
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
