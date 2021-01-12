package com.spring.aop.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @ClassName AppConfig
 * @Description:
 * @Author xgh
 * @Date 2021/1/12
 **/


@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan("com.spring.aop")
public class AppConfig {
}
