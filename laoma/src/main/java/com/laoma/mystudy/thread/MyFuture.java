package com.laoma.mystudy.thread;

public interface MyFuture<V> {
    V get() throws Exception;
}
