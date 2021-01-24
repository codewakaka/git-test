package com.spring.aop.aspect;

import com.spring.aop.dao.Dao;
import com.spring.aop.dao.DaoIndex;
import com.spring.aop.dao.TestIndex;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @ClassName DaoAspect
 * @Description:
 * @Author xgh
 * @Date 2021/1/12
 **/
@Component
@Aspect("perthis(this(com.spring.aop.dao.DaoIndex))")
@Scope("prototype")
public class DaoAspect {

  /*  @DeclareParents(value = "com.spring.aop.dao.*",defaultImpl = TestIndex.class)
    public static Dao dao;*/


    @Pointcut("execution(* com.spring.aop.dao.*.*(..))")
    public void pointCut(){}


  /*  @Before("pointCut()")
    public void execution(){
        System.out.println("before");
    }
*/

    @Around(value = "pointCut()")
    public void around(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println(this.hashCode());
        System.out.println("aaaa");
        Object[] args = proceedingJoinPoint.getArgs();
        if(args != null && args.length>0){
            for (int i = 0; i < args.length; i++) {
              args[i]+= " word";
            }
        }
        try {
            proceedingJoinPoint.proceed(args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("bbbbb");
    }
}
