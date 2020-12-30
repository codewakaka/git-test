package com.myImport.spring.anno;

import com.myImport.spring.test.MyImprotSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author xgh
 * @date ：Created on 2020/12/30
 */

@Retention(RetentionPolicy.RUNTIME)
@Import(MyImprotSelector.class)
public @interface EnableImprot {

}
