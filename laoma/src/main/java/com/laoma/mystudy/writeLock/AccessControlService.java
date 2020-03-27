package com.laoma.mystudy.writeLock;

import java.util.concurrent.Semaphore;


/**
 * 信号量
 *
 * */
public class AccessControlService {
    public static class ConcurrentLimitException extends RuntimeException{
        private static final long serialVersionUID = 1L;
    }
    private static final int MAX_PERMITS= 100;
    private Semaphore permits = new Semaphore(MAX_PERMITS,true);
    public boolean login(){
        if(!permits.tryAcquire()){
            throw new ConcurrentLimitException();
        }
        return true;
    }

    public void logOut(){
        permits.release();
    }
}
