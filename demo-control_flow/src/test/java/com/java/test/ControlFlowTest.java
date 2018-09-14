package com.java.test;



import org.junit.Test;

import java.util.Scanner;

/**
 * Created by Luke Wang on 2018/9/14.
 * 流程控制 测试类
 */
public class ControlFlowTest {

    /**
     * 测试 switch语句的执行顺序
     * <p>
     *     总结：没有 break 的情况下：找到对应的 case 然后依次往下执行<br>
     *         所以建议 default 也添加 break 语句。
     * </p>
     */
    @Test
    public void test02(){
        int i = 2;
        switch (i) {
            case 1:
                System.out.println("one");

            default:
                System.out.println("other");

            case 2:
                System.out.println("two");
        }
    }

   public static void main(String[] args){
        test01();
    }

    /**
     * 由键盘输入三个整数分别存入变量num1、num2、num3，对它们进行排序(使用 if-else if-else),并且从大到小输出。
     */
    public static void test01(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("..........");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();

        if(num1 >= num2){
            if (num3 > num1) {
                System.out.println( num3+"," + num1+"," + num2);
            } else if (num3 < num2) {
                System.out.println( num1+"," + num2+"," + num3);
            }else
                System.out.println( num1+"," + num3+"," + num2);
        } else {
            if (num3 > num2) {
                System.out.println( num3+"," + num2+"," + num1);
            } else if (num3 < num1) {
                System.out.println( num2+"," + num1+"," + num3);
            }else
                System.out.println( num2+"," + num3+"," + num1);
        }
    }
}
