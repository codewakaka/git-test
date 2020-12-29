package com.spring.ann;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author xgh
 * @date ：Created on 2020/12/16
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Myspring {
    public String value();
}
