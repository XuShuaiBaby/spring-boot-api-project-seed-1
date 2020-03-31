package com.company.project.knowledge.demo;

import com.google.common.collect.Lists;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

/**
 * optional类使用demo
* @description
* @author shuai.xu
* @time 2019/1/22 13:56
*/
public class OptionalDemo {

    public static void main(String[] args) {
        ClassName className = new ClassName();
        //className.setName("xushuai");
        Student student = new Student();
        student.setClassName(className);
        School school = new School();
        OptionalSchool optionalSchool = new OptionalSchool();
        //school.setStudent(student);
        /*Optional.of(school)
                .map(School::getStudent)
                .map(Student::getClassName)
                .map(ClassName::getName)
                .ifPresent(System.out::println);*/
        //System.out.println(school.getStudent().getClassName());
        //if (test(school)) return;
        //Optional<ArrayList<Object>> objects = Optional.ofNullable(Lists.newArrayList());
        //System.out.println(school1.map(school2 -> school2.getStudent()).map(student1 -> student1.getClassName()).map(className1 -> className1.getName()).orElse("1"));

        //school1.ifPresent(System.out::println);
        //System.out.println(Optional.of(school).isPresent());
        //System.out.println(Optional.ofNullable(school).isPresent());
        //System.out.println(Optional.of(school).map(School::getStudent).map(Student::getClassName).map(ClassName::getName).orElse("二班"));
        System.out.println(LocalDateTime.of(LocalDate.now(),LocalTime.MIN).with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println(LocalDateTime.of(LocalDate.now(),LocalTime.MAX).with(TemporalAdjusters.firstDayOfMonth()).plusDays(4));
        if (!Optional.of(school).map(School::getStudent).map(Student::getClassName).map(ClassName::getName).isPresent()){
            System.out.println("空对象:"+school);
        }else {
            System.out.println("对象:"+school.getStudent().getClassName().getName());
        }
    }

    private static boolean test(School school) {
        if(school.getStudent() == null){
            return true;
        }
        return false;
    }
}

class School{
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "School{" +
                "student=" + student +
                '}';
    }
}

class OptionalSchool{
    private Optional<OptionalStudent> student;

    public Optional<OptionalStudent> getStudent() {
        return student;
    }

    public void setStudent(Optional<OptionalStudent> student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "OptionalSchool{" +
            "student=" + student +
            '}';
    }
}

class Student{
    private ClassName className;

    public ClassName getClassName() {
        return className;
    }

    public void setClassName(ClassName className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Student{" +
                "className=" + className +
                '}';
    }
}

class OptionalStudent{
    private Optional<ClassName> className;

    public Optional<ClassName> getClassName() {
        return className;
    }

    public void setClassName(Optional<ClassName> className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "optionalStudent{" +
            "className=" + className +
            '}';
    }
}

class ClassName{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ClassName{" +
                "name='" + name + '\'' +
                '}';
    }
}