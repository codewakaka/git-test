package com.myImport.spring.test;

import com.myImport.spring.dao.Dao3;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author xgh
 * @date ：Created on 2020/12/30
 */
public class MyImprotSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{Dao3.class.getName()};
    }
}
