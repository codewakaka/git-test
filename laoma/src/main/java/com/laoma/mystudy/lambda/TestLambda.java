package com.laoma.mystudy.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestLambda {
    public static void main(String[] args) {
        Random random = new Random();
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 100 ; i++) {
            students.add(new Student("cs"+i,random.nextInt(100)));
        }

    }

    public static boolean test(Student student){
        return student.getScore()>90 && student.getScore() <95;
    }

}
