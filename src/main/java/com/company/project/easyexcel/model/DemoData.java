package com.company.project.easyexcel.model;

import com.alibaba.excel.annotation.ExcelProperty;

import java.util.Date;

public class DemoData {

    @ExcelProperty(value = "名字",index = 0)
    private String string;

    @ExcelProperty(value = "时间",index = 1)
    private Date date;

    @ExcelProperty(value = "工资",index = 2)
    private Double doubleData;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getDoubleData() {
        return doubleData;
    }

    public void setDoubleData(Double doubleData) {
        this.doubleData = doubleData;
    }

    @Override
    public String toString() {
        return "DemoData{" +
                "string='" + string + '\'' +
                ", date=" + date +
                ", doubleData=" + doubleData +
                '}';
    }
}
