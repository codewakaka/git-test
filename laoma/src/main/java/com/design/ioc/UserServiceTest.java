package com.design.ioc;

public class UserServiceTest {

    public static  boolean  doTests(){
        System.out.println("this is test");
        return true;
    }

    public static void main(String[] args) {
        if(doTests()){
            System.out.println("true test");
        }else {
            System.out.println("error test");
        }
    }
}
