package com.java.staticProxy;

/**
 * Created by Luke Wang on 2018/8/31.
 *
 * 静态代理模式：二、创建被代理类，实现接口
 */
public class NikeClothFactory implements ClothFactory {
    @Override
    public void productCloth() {
        System.out.println("Nike工厂生产一批衣服");
    }
}
