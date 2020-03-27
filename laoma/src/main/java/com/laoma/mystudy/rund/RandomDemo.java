package com.laoma.mystudy.rund;

import java.util.Random;

public class RandomDemo {

    public static void basic(){
        Random random = new Random();
        System.out.println(random.nextInt());
        System.out.println(random.nextInt(100));
        for (int i = 0; i < 3; i++) {
            System.out.println(Math.random());
        }
    }
    public static String randomPassword(){
        char[] chars = new char[6];
        Random  ram = new Random();
        for (int i = 0; i <6 ; i++) {
            chars[i] = (char)('0'+ ram.nextInt(10));
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(randomPassword());
    }
}
