package com.java.test;

import org.junit.Test;

/**
 * Created by Luke Wang on 2018/9/13.
 * 运算符 测试类
 */
public class OperatorsTest {

    /**
     * 测试【三目运算符】
     */
    @Test
    public void test04(){
        //当需要把三目运算的值赋值给变量时，要求表达式1和表达式2是相同类型。
        String s = 2 > 1 ? String.valueOf(5) : "hehe";
        System.out.println(s);
        //当直接输出三目运算的值时，不要求两个表达式的类型相同。
        System.out.println((3<2)?3+5:"hehe");
    }

    /**
     * 测试【位运算符】
     * 交换两个变量的值
     */
    @Test
    public void test03(){

        //方法一：通过临时变量交换
        int m1 = 1;
        int n1 = 10;
        System.out.println("交换前：m= "+m1+"\t"+"n= "+n1);
        int temp;
        temp = m1;
        m1 = n1;
        n1 = temp;
        System.out.println("交换前：m= "+m1+"\t"+"n= "+n1);

        //方法二：通过算术运算交换
        int m2 = 1;
        int n2 = 10;
        System.out.println("交换前：m= "+m2+"\t"+"n= "+n2);
        m2 = m2 + n2;
        n2 = m2 - n2;
        m2 = m2 - n2;
        System.out.println("交换前：m= "+m2+"\t"+"n= "+n2);

        //方法三：通过位运算交换
        int m3 = 1;
        int n3 = 10;
        System.out.println("交换前：m= "+m3+"\t"+"n= "+n3);
        m3 = m3 ^ n3;
        n3 = m3 ^ n3;
        m3 = m3 ^ n3;
        System.out.println("交换前：m= "+m3+"\t"+"n= "+n3);
    }

    /**
     * 测试【赋值运算符】
     */
    @Test
    public void test02(){
        byte s = 1;
        s += 127; //既可以实现运算，又不会改变数据类型
        //s = (byte) (s + 1);
        System.out.println(s);  //-128

        int i = 1;
        i *= 0.1;
        System.out.println(i); //0

    }

    /**
     * 测试【算术运算符】
     */
    @Test
    public void test01(){

        /*
        * 测试【取余】的规律
        * 规律：余数的正负号与被取余数的正负号相同
        */
        int i1 = 12 % 5;
        int i2 = 12 % -5;
        int i3 = -12 % 5;
        int i4 = -12 % -5;
        System.out.println(i1); //2
        System.out.println(i2); //2
        System.out.println(i3); //-2
        System.out.println(i4); //-2

        System.out.println('*' + '\t' +'*');
        System.out.println("*" + '\t' +'*');
    }
}
