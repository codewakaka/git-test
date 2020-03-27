package com.thread;


public class ThreadSafeTemple {
    public int safeSate;

    public void noSafeAction() {
        while (safeSate < 100000) {
          synchronized (this){
              int a = safeSate++;
              int b = safeSate;
              if (a != b - 1) {
                  System.out.println("a is " + a + "===   b is " + b);
              }
          }
        }
    }

    public static void main(String[] args) {
        ThreadSafeTemple threadSafeTemple = new ThreadSafeTemple();
        Thread a = new Thread(){
            @Override
            public void run() {
                threadSafeTemple.noSafeAction();
            }
        };
        Thread b = new Thread(){
            @Override
            public void run() {
                threadSafeTemple.noSafeAction();
            }
        };
        a.start();
        b.start();
        try {
            a.join();
            b.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
