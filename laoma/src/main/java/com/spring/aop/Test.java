package com.spring.aop;

import com.spring.aop.config.AppConfig;
import com.spring.aop.dao.Dao;
import com.spring.aop.dao.DaoIndex;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Proxy;

/**
 * @ClassName Test
 * @Description:
 * @Author xgh
 * @Date 2021/1/12
 **/
public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        Dao dao = (Dao) configApplicationContext.getBean("daoIndex");
        Dao dao1 = (Dao) configApplicationContext.getBean("daoIndex");
        System.out.println(dao1.hashCode() +"====="+dao.hashCode());
        dao.query2();
        dao1.query2();

        //  Dao dao = (Dao) configApplicationContext.getBean("daoIndex");
      /*  dao.query("hello");
        System.out.println("=================");
        dao.query2();*/
    }
}
