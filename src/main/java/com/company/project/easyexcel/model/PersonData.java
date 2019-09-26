package com.company.project.easyexcel.model;

import com.alibaba.excel.annotation.ExcelProperty;

public class PersonData {

    @ExcelProperty(value = "名字")
    private String name;

    @ExcelProperty(value = "年龄")
    private Integer age;

    @ExcelProperty(value = "工作")
    private String work;

    @ExcelProperty(value = "住址")
    private String address;

    @ExcelProperty(value = "电话")
    private String iphone;

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

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIphone() {
        return iphone;
    }

    public void setIphone(String iphone) {
        this.iphone = iphone;
    }


}
