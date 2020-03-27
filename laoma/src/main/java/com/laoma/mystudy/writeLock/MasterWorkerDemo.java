package com.laoma.mystudy.writeLock;

import java.util.concurrent.CountDownLatch;

public class MasterWorkerDemo {
    static class Worker extends Thread{
        CountDownLatch latch;
        public Worker(CountDownLatch latch){
            this.latch = latch ;
        }

        @Override
        public void run() {
                try {
                    Thread.sleep((int)Math.random() * 1000);
                    if(Math.random() <0.02){
                        throw  new RuntimeException("back lock");
                    }
                } catch (InterruptedException e) {

                }finally {
                    this.latch.countDown();
                }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        int workNum = 100;
        CountDownLatch latch = new CountDownLatch(workNum);
        Worker[] workers = new Worker[workNum];
        for (int i = 0; i < workNum; i++) {
            workers[i]  = new Worker(latch);
            workers[i].start();
        }
        latch.await();
        System.out.println("collect worek resulters");
    }
}
