package com.laoma.mystudy.writeLock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
     static class  Tourist extends Thread{
         CyclicBarrier barrier;
         public Tourist(CyclicBarrier barrier){
             this.barrier = barrier;
         }

         @Override
         public void run() {

             try {
                 //模拟各自的独立运行
                 Thread.sleep((int)Math.random() * 1000);
                 //集合点a
                 barrier.await();
                 System.out.println(this.getName() +" arrived a " +System.currentTimeMillis());
                 //集合后再独立运动
                 Thread.sleep((int)Math.random() *1000);
                 barrier.await();
                 System.out.println(this.getName() + " arrived b " +System.currentTimeMillis() );
             } catch (InterruptedException e) {
                 e.printStackTrace();
             } catch (BrokenBarrierException e) {
                 e.printStackTrace();
             }

                      }
     }

    public static void main(String[] args) {
        int num = 3;
        Tourist[] tourists = new Tourist[num];
        CyclicBarrier barrier = new CyclicBarrier(num, new Runnable() {
            @Override
            public void run() {
                System.out.println(" all arrived " + System.currentTimeMillis() + " executed by " + Thread.currentThread().getName());
            }
        });
        for (int i = 0; i < num ; i++) {
            tourists[i] = new Tourist(barrier);
            tourists[i].start();
        }

    }
}
