package com.laoma.mystudy.proxy;

/**
 * @author xgh
 * @date ：Created on 2020/12/4
 */
public class MyDaoImpe implements MyDao{
    @Override
    public String query() {
        System.out.println("-----------query--------");
        return "query";
    }

    @Override
    public String proxy() {
        System.out.println("-----------proxy--------");
        return "proxy";
    }
}
