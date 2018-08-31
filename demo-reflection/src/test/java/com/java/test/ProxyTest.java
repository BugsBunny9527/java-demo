package com.java.test;

import com.java.dynamicProxy.MyInvocationHandler;
import com.java.dynamicProxy.Realsubject;
import com.java.dynamicProxy.Subject;
import com.java.staticProxy.NikeClothFactory;
import com.java.staticProxy.ProxyFactory;
import org.junit.Test;

/**
 * Created by Luke Wang on 2018/8/31.
 * Java代理 测试类
 */
public class ProxyTest {

    /**
     * 动态代理模式：
     * 一、创建接口
     * 二、创建被代理类，实现接口
     * 三、创建自定义Handler类，实现 InvocationHandler 接口
     *
     */
    @Test
    public void test02(){
        //创建被代理类对象
        Realsubject realsubject = new Realsubject();
        //创建一个实现了InvacationHandler接口的类的对象
        MyInvocationHandler handler = new MyInvocationHandler();
        //调用blind()方法，动态的返回一个同样实现了real所在类实现的接口Subject的代理类的对象。
        Object obj = handler.bind(realsubject);
        Subject subject = (Subject)obj;//此时obj就是代理类的对象

        subject.action();//转到对InvacationHandler接口的实现类的invoke()方法的调用
    }

    /**
     * 静态代理模式：
     * 一、创建接口
     * 二、创建被代理类，实现接口
     * 三、创建代理类，实现接口
     *
     */
    @Test
    public void test01(){
        //创建被代理类的对象
        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        //创建代理类的对象，绑定被代理类对象
        ProxyFactory proxyFactory = new ProxyFactory(nikeClothFactory);
        //通过代理对象执行被代理对对象的方法
        proxyFactory.productCloth();
    }
}
