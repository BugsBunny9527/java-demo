package com.java.reflection;

/**
 * Created by Luke Wang on 2018/8/31.
 */
public class Person {
    public String name;
    private int age;

    public Person() {
        System.out.println("执行 Person 类的默认构造器。。。");
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void show(){
        System.out.println("我是一个人。");

    }

    public void display(String nation) {
        System.out.println("我的国籍是：" + nation);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
