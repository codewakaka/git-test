package com.design.ioc;

public abstract class TestCase {

    protected abstract boolean doTest();

    public void run() {
        if(doTest()){
            System.out.println("true test");
        }else {
            System.out.println("error test");
        }
    }
}
