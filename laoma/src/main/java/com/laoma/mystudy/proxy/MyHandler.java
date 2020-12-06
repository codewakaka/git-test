package com.laoma.mystudy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author xgh
 * @date ：Created on 2020/12/4
 */
public class MyHandler implements InvocationHandler {

    private final Object targer;

    public MyHandler(Object targer){
        this.targer = targer;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("---invoke---");
        return method.invoke(targer,args);
    }
}
