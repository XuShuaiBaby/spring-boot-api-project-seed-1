package com.company.project.predicatetest;

import com.company.project.model.Goods;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

public class ConsumerDemo {

    @Test
    public void cutHand() {
        Goods goods = new Goods(1,"口红", 288);

        //土豪
        spentMoney(goods, (g) -> System.out.println("消费" + g.getPrice() + "元"));

        System.out.println("-------------------贫富分割线--------------------");

        //屌丝
        spentMoneyAndLog(goods, (g) -> {
            System.out.println("消费" + g.getPrice() + "元");
            g.setPrice(g.getPrice()-10);
        });
    }

    //任性地花
    public void spentMoney(Goods goods, Consumer<Goods> consumer) {
        consumer.accept(goods);
    }

    //花一笔记一笔
    public void spentMoneyAndLog(Goods goods, Consumer<Goods> consumer) {
        Consumer<Goods> logConsumer = (g) -> System.out.println("买" + g.getName() + "用了" + g.getPrice() + "元！");
        consumer.andThen(logConsumer).accept(goods);
    }
}
