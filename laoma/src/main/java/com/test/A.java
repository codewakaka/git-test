package com.test;

/**
 * @author xgh
 * @date ：Created on 2020/3/24
 */
public class A {

    private static volatile A a = null;

    private A() {
    }


    public A getInstnce() {
        if (a == null) {
            synchronized (A.class) {
                if (a == null) {
                    a = new A();
                }
            }
        }
        return a;
    }

}
