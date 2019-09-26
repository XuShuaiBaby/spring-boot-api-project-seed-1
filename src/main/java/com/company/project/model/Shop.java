package com.company.project.model;

import java.util.List;

public class Shop {

    private String name;
    private List<Goods> goodsList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "name='" + name + '\'' +
                ", goodsList=" + goodsList +
                '}';
    }
}
