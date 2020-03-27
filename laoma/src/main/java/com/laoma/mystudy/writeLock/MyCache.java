package com.laoma.mystudy.writeLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyCache {
    private Map<String,Object> map = new HashMap<String, Object>();
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock  readLock = readWriteLock.readLock();
    private Lock writeLock = readWriteLock.readLock();
    public Object get(String key){
        readLock.lock();
        try {
            return map.get(key);
        }finally {
            readLock.unlock();
        }
    }

    public Object put(String key,String value){
        writeLock.lock();
        try {
            return map.put(key,value);
        }finally {
            writeLock.unlock();
        }
    }
    public void clean(){
        writeLock.lock();
        try {
            map.clear();
        }finally {
            writeLock.unlock();
        }
    }
}
