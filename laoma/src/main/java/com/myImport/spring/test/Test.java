package com.myImport.spring.test;

import com.myImport.spring.config.Appliction;
import com.myImport.spring.dao.CardDao;
import com.myImport.spring.dao.Dao;
import com.myImport.spring.dao.Dao2;
import com.myImport.spring.service.DaoService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xgh
 * @date ：Created on 2020/12/30
 */
public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Appliction.class);
        context.refresh();
     /*   context.getBean(DaoService.class).list();

       CardDao cardDao =(CardDao) context.getBean("cardDao");
       cardDao.list();*/
        System.out.println("===="+ context.getBean(Dao2.class).hashCode());
        System.out.println("========"+ context.getBean(Dao2.class).hashCode());
    }
}
