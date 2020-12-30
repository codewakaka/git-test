package com.myImport.spring.dao;

import org.apache.ibatis.annotations.Select;

/**
 * @author xgh
 * @date ：Created on 2020/12/30
 */

public interface CardDao {

    @Select("select * from qqq")
    void list();
}
