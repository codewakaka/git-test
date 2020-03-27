package com.laoma.mystudy.syn;

public class MySyn {
    public static void main(String[] args) {
        synchronized (MySyn.class){
            System.out.println(111);
        }
    }
}
