package com.spring.aop.dao;

import org.springframework.stereotype.Repository;

/**
 * @ClassName DaoIndex
 * @Description:
 * @Author xgh
 * @Date 2021/1/12
 **/
@Repository()
public class TestIndex implements Dao{

    @Override
    public void query( String a)
    {

        System.out.println(a);
    }

    @Override
    public void query2() {
        System.out.println("query test");
    }
}
