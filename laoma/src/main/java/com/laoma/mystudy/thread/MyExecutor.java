package com.laoma.mystudy.thread;

import java.util.concurrent.Callable;

public class MyExecutor {

    static  class ExecuteThread<V> extends Thread{
        private V result = null;
        private Exception exception = null;
        private  boolean done = false;
        private Callable<V> task;
        private Object lock;
        public ExecuteThread(Callable<V> task,Object lock){
            this.task = task;
            this.lock = lock;
        }
        @Override
        public void run(){
            try {
                task.call();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                synchronized (lock){
                    done = true;
                    lock.notifyAll();
                }
            }
        }
        public V getResult() {
            return result;
        }

        public boolean isDone() {
            return done;
        }

        public Exception getException() {
            return exception;
        }

    }
    public <V> MyFuture<V> execute(final Callable<V> task ){
        final Object lock = new Object();
        final ExecuteThread<V> therad = new ExecuteThread<V>(task,lock);
        therad.start();

        MyFuture<V> future = new MyFuture<V>() {
            public V get() throws Exception {
                synchronized (lock){
                    lock.wait();
                    if (therad.getException() != null){
                        throw  therad.getException();
                    }
                    return therad.getResult();
                }
            }
        };
        return future;
    }

    public static void main(String[] args) {
        MyExecutor executor = new MyExecutor();
        //子任务

        Callable<Integer> subTask = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int millis = (int) (Math.random()*1000);
                Thread.sleep(millis);
                System.out.println(millis);
                return millis;
            }
        };
        //异步调用
        MyFuture<Integer> future = executor.execute(subTask);
        try {
            Integer integer = future.get();
            System.out.println("====="+integer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
