package com.myImport.spring.dao;

import com.myImport.spring.test.MyHandler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Proxy;

/**
 * @author xgh
 * @date ：Created on 2020/12/30
 */
public class Dao3 implements BeanPostProcessor {



    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //前置方法处理
        if(beanName.equals("dao1")){
            bean = Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{Dao.class},new MyHandler(bean));
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }
}
