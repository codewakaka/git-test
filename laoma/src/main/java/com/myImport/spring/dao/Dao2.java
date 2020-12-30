package com.myImport.spring.dao;

import org.springframework.stereotype.Component;

/**
 * @author xgh
 * @date ：Created on 2020/12/30
 */
@Component
public class Dao2 implements Dao{
    @Override
    public void query() {
        System.out.println("我是dao2的 query ");
    }
}
