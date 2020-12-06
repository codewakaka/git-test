package com.laoma.mystudy.thread;

/**
 * @author xgh
 * @date ：Created on 2020/7/30
 */
public interface Computable<A,V> {

     V compute(A arg)throws InterruptedException;
}
