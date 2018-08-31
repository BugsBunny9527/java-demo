package com.java.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Luke Wang on 2018/8/31.
 * 动态代理模式：三、创建一个Handler实现 InvocationHandler 接口
 */
public class MyInvocationHandler implements InvocationHandler {

    /**
     * 实现了接口的被代理类的对象的声明
     */
    private Object object;

    /**
     * 该方法的作用：
     * ①给被代理的对象实例化
     * ②返回一个代理类的对象
     * @param object
     * @return
     */
    public Object bind(Object object){
        this.object = object;

        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
    }

    /**
     *当通过代理类的对象发起对被重写的方法的调用时，都会转换为对如下的invoke方法的调用
     * 
     * @param proxy
     * @param method
     * @param args
     * @return 被调用的方法的返回值
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理类开始执行，收代理费$1000");
        //method方法的返回值
        return method.invoke(object, args);
    }
}
