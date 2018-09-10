package com.java.test;

import org.junit.Test;

/**
 * Created by Luke Wang on 2018/9/10.
 * 基本数据类型 测试类
 */
public class PrimitiveTypesTest {

    /**
     * 自动类型转换测试
     */
    public void test01(){
        byte b1 = 1;
        short s1 = 10;
        char c1 = 'a';

        /*
        * 当 char、byte、short 之间做运算时，结果会转为 int 类型。
        */
        //short s2 = b1 + s1;
        int i1 = b1 + s1;

        //char c2 = c1 + s1;
        int i2 = c1 + s1;

    }

    /**
     * 强制类型转换测试
     */
    @Test
    public void test02(){
        int i = 123456;
        byte b = (byte) i;
        //强制类型转换的潜在问题：精度的丢失。
        System.out.println(b);//64
    }
}
