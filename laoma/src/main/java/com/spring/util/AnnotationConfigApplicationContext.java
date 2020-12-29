package com.spring.util;

import com.spring.ann.Myspring;

import java.io.File;

/**
 * @author xgh
 * @date ：Created on 2020/12/16
 */
public class AnnotationConfigApplicationContext {
    
    public void scan(String packagePath){
        //得到文件路径，扫描路径下点的文件，判断是否添加了注解
        String filePath = this.getClass().getResource("/").getPath();
        String packagePaths = filePath +packagePath.replaceAll("\\.","/");
        File file  = new File(packagePaths);

        String[] calssNames = file.list();
        assert calssNames != null;
        for (String calssName : calssNames) {

            try {
                Class<?> aClass = Class.forName(packagePath +"."+calssName.replaceAll(".class",""));
                if(aClass.isAnnotationPresent(Myspring.class)){
                    Myspring annotation = aClass.getAnnotation(Myspring.class);
                    System.out.println(annotation.value());
                    Object o = aClass.newInstance();
                    System.out.println(o);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.spring.service");
    }
}
