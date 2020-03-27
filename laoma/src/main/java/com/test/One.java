package com.test;

import java.util.concurrent.locks.Lock;

/**
 * @author xgh
 * @date ：Created on 2020/3/23
 */
public class One {

    public static volatile  int sum = 1;


    public static void main(String[] args) throws InterruptedException {
        final Object object = new Object();
        Thread  t1 = new Thread(()-> {
            while(sum<100) {
                for (int i = 0; i < 99; i++) {
                    synchronized (object) {
                        if(i%2 == 0) {
                            try {
                                object.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            ;
                        } else {
                            System.out.println(i++);
                        }
                    }
                }

            }
        });
        Thread  t2 = new Thread(()-> {
            while(sum<100) {
                for (int i = 0; i < 99; i++) {
                    synchronized (object) {
                        if (i % 2 == 1) {
                            try {
                                object.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            ;
                        } else {
                            System.out.println(i++);
                        }
                    }
                }
             }
            });

        t1.start();
        t2.start();

    }

    public void test(){
        System.out.println(11111);
    }

}
