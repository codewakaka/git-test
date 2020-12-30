package com.myImport.spring.service;

import com.myImport.spring.dao.CardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xgh
 * @date ：Created on 2020/12/30
 */
@Component
public class DaoService {

    @Autowired
    CardDao cardDao;

    public void  list(){
        System.out.println("dao service query");
        cardDao.list();
    }
}
