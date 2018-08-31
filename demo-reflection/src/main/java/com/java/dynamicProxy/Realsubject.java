package com.java.dynamicProxy;

/**
 * Created by Luke Wang on 2018/8/31.
 * 动态代理模式：二、创建被代理类，实现接口
 */
public class Realsubject implements Subject {
    @Override
    public void action() {
        System.out.println("我是被代理类，记得要执行我哦！么么哒~~");
    }
}
