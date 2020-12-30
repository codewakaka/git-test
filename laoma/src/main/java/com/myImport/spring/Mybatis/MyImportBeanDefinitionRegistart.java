package com.myImport.spring.Mybatis;

import com.myImport.spring.dao.CardDao;
import com.myImport.spring.factoryBean.MyFactoryBean;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Objects;

/**
 * @author xgh
 * @date ：Created on 2020/12/30
 */
public class MyImportBeanDefinitionRegistart implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        //通过包名扫描\
        BeanDefinitionBuilder holder = BeanDefinitionBuilder.genericBeanDefinition(CardDao.class);
        GenericBeanDefinition genericBeanDefinition = (GenericBeanDefinition) holder.getBeanDefinition();
        //修改bean的type
        genericBeanDefinition.getConstructorArgumentValues().addGenericArgumentValue(Objects.requireNonNull(genericBeanDefinition.getBeanClassName()));
        genericBeanDefinition.setBeanClass(MyFactoryBean.class);
        //然后注册回去
        beanDefinitionRegistry.registerBeanDefinition("cardDao",genericBeanDefinition);
    }
}
