package com.myImport.spring.dao;

import org.springframework.stereotype.Component;

/**
 * @author xgh
 * @date ：Created on 2020/12/30
 */
@Component
public class Dao1 implements Dao{

    public Dao1() {
        System.out.println( "dao1 init ");
    }

    @Override
    public void query() {
        System.out.println("我是dao1 的query");
    }
}
