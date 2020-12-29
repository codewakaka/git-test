package com.spring.service;

import com.spring.ann.Myspring;
import com.spring.dao.UserDao;

/**
 * @author xgh
 * @date ：Created on 2020/12/6
 */
@Myspring("myspring")
public class UserServiceImpl implements  UserService{

    UserDao dao;



    @Override
    public void find() {
        System.out.println("service");
        dao.query();
    }


    public void setDao(UserDao dao) {
        this.dao = dao;
    }
}
