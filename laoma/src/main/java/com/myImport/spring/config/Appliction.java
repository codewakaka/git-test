package com.myImport.spring.config;

import com.myImport.spring.anno.EnableImprot;
import com.myImport.spring.anno.MyMapperScan;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author xgh
 * @date ：Created on 2020/12/30
 */
@Configurable
@ComponentScan("com.myImport.spring")
//@EnableImprot
@MyMapperScan
public class Appliction {


}
