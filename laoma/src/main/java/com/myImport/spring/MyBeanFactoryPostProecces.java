package com.myImport.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author xgh
 * @date ：Created on 2020/12/30
 */
@Component
public class MyBeanFactoryPostProecces implements BeanFactoryPostProcessor {


    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
       AnnotatedBeanDefinition beanDefinition = (AnnotatedBeanDefinition) configurableListableBeanFactory.getBeanDefinition("dao2");
       beanDefinition.setScope("prototype");
    }
}
