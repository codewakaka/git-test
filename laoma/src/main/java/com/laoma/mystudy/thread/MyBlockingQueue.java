package com.laoma.mystudy.thread;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<E> {
    private Queue<E> queue = null;
    private int limit;
    private Lock lock = new ReentrantLock();
    private Condition motFull = lock.newCondition();
    private Condition notEmputy = lock.newCondition();

    public MyBlockingQueue(int limit) {
        this.limit = limit;
        queue = new ArrayDeque<E>(limit);
    }

    public void put(E e) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (queue.size() == limit) {
                motFull.await();
            }
            queue.add(e);
            notEmputy.signal();
        } finally {
            lock.unlock();
        }
    }

    public E take() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (queue.isEmpty()) {
                notEmputy.await();
            }
              E e =  queue.poll();
            motFull.signal();
            return e;
        }finally {
            lock.unlock();
        }

    }
}
