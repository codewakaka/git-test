package com.laoma.mystudy.lambda;

import lombok.Data;

/**
 * @author xgh
 * @date ：Created on 2020/4/3
 */
@Data
public class Employee {
    private String name;
    private int age;
    private double salary;

    public Employee() {
    }

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
}
