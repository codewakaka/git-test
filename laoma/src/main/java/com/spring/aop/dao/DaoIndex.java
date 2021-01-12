package com.spring.aop.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * @ClassName DaoIndex
 * @Description:
 * @Author xgh
 * @Date 2021/1/12
 **/
@Repository("daoIndex")
@Scope("prototype")
public class DaoIndex implements Dao{

    @Override
    public void query( String a)
    {
        System.out.println("query1");
        System.out.println(a);
    }

    @Override
    public void query2() {
        System.out.println("query2");
    }
}
