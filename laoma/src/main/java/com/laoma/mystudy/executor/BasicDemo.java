package com.laoma.mystudy.executor;

import java.util.Random;
import java.util.concurrent.*;

public class BasicDemo {
    static class Task implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            int nextInt = new Random().nextInt(1000);
            System.out.println(1111);
            Thread.sleep(nextInt);
            return nextInt;
        }
    }
    /**
     *
     *
     * */
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(new Task());
        Thread.sleep(100);
        try {
            System.out.println(future.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
