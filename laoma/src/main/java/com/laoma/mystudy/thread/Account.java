package com.laoma.mystudy.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private Lock lock  = new ReentrantLock();
    private volatile double money;
    public Account(double initMoney){
        this.money = initMoney;
    }
    public void add(double money){
        lock.lock();
        try {
            this.money += money;
        }finally {
            lock.unlock();
        }
    }
    public void reduce(double money){
        lock.lock();
        try {
            this.money -= money;
        }finally {
            lock.unlock();
        }

    }
    public double getMoney(){
        return money;
    }
    boolean tryLock(){
        return lock.tryLock();
    }
    void lock(){
        lock.lock();
    }
    void unlock(){
        lock.unlock();
    }


}