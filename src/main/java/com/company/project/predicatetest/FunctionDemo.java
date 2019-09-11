package com.company.project.predicatetest;

import com.company.project.model.Goods;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

public class FunctionDemo {

    @Test
    public void life() {
        //第一次，妈妈给小明10元去买酱油
        double tips = firstBuy(10, (m) -> Double.valueOf(10 - getSoy().getPrice()));
        //System.out.println("小明得到的小费：" + tips);

        //第二次，妈妈还是给小明10元买酱油，小明思考了一下，拒绝了
        //System.out.println("小明将妈妈给的" + Function.identity().apply(10) + "元还了回去");

        //妈妈在了解完情况后，给了小明20元去买，小明当然很愉快去了
        double tips2 = secondBuy(20, (m) -> {
            System.out.println("买酱油前有" + m + "元");
            double v2 = m - getSoy().getPrice();
            System.out.println("买完酱油后剩下" + v2 + "元");
            return v2;
        });
        System.out.println("小明剩下的小费：" + tips2);

        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.andThen(g);//类似数学里的g(f(x))把f函数的结果作为g函数的参数
        Function<Integer, Integer> i = f.compose(g);//类似数学里的f(g(x))把g函数的结果作为f函数的参数
        int result = h.apply(3);
        System.out.println(result);
        int result1 = i.apply(2);
        System.out.println(result1);

    }

    public double firstBuy(double money, Function<Double, Double> buy) {
        return buy.apply(money);
    }

    public double secondBuy(double money, Function<Double, Double> buy) {
        //在去的路上小明先买了冰淇淋
        Function<Double, Double> beforeBuy = (m) -> {
            System.out.println("第一次买冰淇淋前有" + m + "元");
            double v1 = m - getIceCream().getPrice();
            System.out.println("买完冰淇淋后剩下" + v1 + "元");
            return v1;
        };

        //回来的路上小明又买了冰淇淋
        Function<Double, Double> afterBuy = (m) -> {
            System.out.println("第二次买冰淇淋前有" + m + "元");
            double v3 = m - getIceCream().getPrice();
            System.out.println("买完冰淇淋后剩下" + v3 + "元");
            return v3;
        };

        return buy.compose(beforeBuy).andThen(afterBuy).apply(money);
    }

    public Goods getSoy() {
        return new Goods(2,"酱油", 10);
    }

    public Goods getIceCream() {
        return new Goods(1,"冰淇淋", 5);
    }
}
