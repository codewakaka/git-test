package com.spring;

import com.spring.service.UserService;
import com.spring.util.BeanFactory;

/**
 * @author xgh
 * @date ：Created on 2020/12/6
 */
public class Test {
    public static void main(String[] args) {
       /* BeanFactory beanFactory = new BeanFactory("spring.xml");
        UserService userService = (UserService) beanFactory.getBean("service");
        userService.find();*/
    /*    String a = "abc";
        String b = new String("abc");
        String c = b.intern();
        System.out.println(a==b);
        System.out.println(c==b);
        System.out.println(a==c);*/

        String e = new String("张")+new String("三");
        String f = e.intern();
        System.out.println(e == f);

    }
}
