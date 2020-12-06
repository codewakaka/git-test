package com.spring;

import com.spring.service.UserService;
import com.spring.util.BeanFactory;

/**
 * @author xgh
 * @date ：Created on 2020/12/6
 */
public class Test {
    public static void main(String[] args) {
        BeanFactory beanFactory = new BeanFactory("spring.xml");
        UserService userService = (UserService) beanFactory.getBean("service");
        userService.find();
    }
}
