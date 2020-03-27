package com.laoma.mystudy.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScbeduledFixedDelay {
    static class LongRuntimeTask implements Runnable{
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("long run finished");
        }
    }
    static class FixedDealayTask implements Runnable{
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis());
        }
    }

    public static void main(String[] args) {
        ScheduledExecutorService time = Executors.newScheduledThreadPool(10);
        time.schedule(new LongRuntimeTask(),10, TimeUnit.MILLISECONDS);
        time.scheduleWithFixedDelay(new FixedDealayTask(),100,1000,TimeUnit.MILLISECONDS);
    }
}
