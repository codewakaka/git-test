package com.myImport.spring.factoryBean;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author xgh
 * @date ：Created on 2020/12/30
 */
public class MyFactoryBean implements FactoryBean, InvocationHandler {
    Class clazz;

    public MyFactoryBean(Class clazz) {
        this.clazz = clazz;
    }

    @Override
    public Object getObject() throws Exception {
        Class[] classes = new Class[]{clazz};
        Object o = Proxy.newProxyInstance(this.clazz.getClassLoader(), classes, this);
        return o;
    }

    @Override
    public Class<?> getObjectType() {
        return clazz;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是代理 proxy");
        Method method1 = proxy.getClass().getInterfaces()[0].getMethod(method.getName());
        Select annotation = method1.getAnnotation(Select.class);
        System.out.println(annotation.value()[0]);
        return null;
    }
}
