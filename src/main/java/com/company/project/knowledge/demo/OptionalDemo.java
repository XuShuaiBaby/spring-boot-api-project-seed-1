package com.company.project.knowledge.demo;

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
        school.setStudent(student);
        /*Optional.of(school)
                .map(School::getStudent)
                .map(Student::getClassName)
                .map(ClassName::getName)
                .ifPresent(System.out::println);*/
        //System.out.println(school.getStudent().getClassName());
        Optional<School> school1 = Optional.ofNullable(school);
        //school1.ifPresent(System.out::println);
        //System.out.println(Optional.of(school).isPresent());
        //System.out.println(Optional.ofNullable(school).isPresent());
        if (!Optional.ofNullable(school).map(School::getStudent).map(Student::getClassName).map(ClassName::getName).isPresent()){
            System.out.println("空对象:"+school);
        }else {
            System.out.println("对象:"+school.getStudent().getClassName().getName());
        }
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