package com.laoma.mystudy;

import java.lang.reflect.Field;

/**
 * @author xgh
 * @date ：Created on 2020/3/1
 */
public class App {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Integer a=1,b=2;//Integer a = Integer.inValueOf(1)
        System.out.println("before a:= "+a+" b:="+b);
        swap(a,b);

        System.out.println("after a:= "+a+" b:="+b);
    }

    private static void swap(Integer i1, Integer i2) throws NoSuchFieldException, IllegalAccessException {

        Field field = Integer.class.getDeclaredField("value");
        field.setAccessible(true);
        Integer tep = new Integer(i1.intValue());
        field.set(i1,i2);
        field.set(i2,tep);
    }
}
