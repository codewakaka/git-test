package com.jvm.ex3;
/**
 * @author King老师
 * JVM遇到new关键字
 *
 **/
public class ObjectCreate {
    private int age;
    private boolean isKing;
    public static void main(String[] args) {
        ObjectCreate objectCreate = new ObjectCreate();//
        System.out.println(objectCreate.age);
        System.out.println(objectCreate.isKing);
        //if else
    }
}
