package com.myImport.spring.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author xgh
 * @date ：Created on 2020/12/30
 */
public class MyHandler implements InvocationHandler {

    Object target;

    public MyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是代理方法=======");
        return method.invoke(target,args);
    }
}
