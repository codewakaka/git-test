package com.laoma.mystudy.localThread;

public class ThreadLocalBaser {

    static ThreadLocal<Integer> local = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        local.set(100);
        Thread chiled = new Thread(){
            @Override
            public void run() {
                System.out.println(" child thread initial:  " + local.get());
                local.set(200);
                System.out.println(" child thread end:  " + local.get());
            }
        };
        local.set(100);
        chiled.start();
        chiled.join();
        System.out.println(" base thread  "+ local.get());
    }
}