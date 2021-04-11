package com.jvm.ex1;
/**
 * @author King老师
 * 虚拟机栈溢出
 */
public class StackError {
    public static void main(String[] args) {
        A();
    }
    public static void A(){
        A();
    }
}
