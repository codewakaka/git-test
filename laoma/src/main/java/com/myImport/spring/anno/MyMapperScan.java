package com.myImport.spring.anno;

import com.myImport.spring.Mybatis.MyImportBeanDefinitionRegistart;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author xgh
 * @date ：Created on 2020/12/30
 */

@Retention(RetentionPolicy.RUNTIME)
@Import(MyImportBeanDefinitionRegistart.class)
public @interface MyMapperScan {
}
