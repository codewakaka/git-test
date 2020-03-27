package com.design.ioc;

import java.util.ArrayList;
import java.util.List;

public class JunitApplication {

    private static final List<TestCase> caseList = new ArrayList<>();

    public static void  Regist(TestCase testCase){
        caseList.add(testCase);
    }

    public static void main(String[] args) {
        Regist(new MyUsreServiceTest());
        for (TestCase testCase : caseList) {
            testCase.run();
        }
    }
}
