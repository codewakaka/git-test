package com.laoma.mystudy.thread;


import java.util.concurrent.*;

/**
 * @author xgh
 * @date ：Created on 2020/7/30
 */
public class Memoizerl<A, V> implements Computable<A, V> {

    private final ConcurrentHashMap<A, Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();
    private final Computable<A, V> c;

    public Memoizerl(Computable<A, V> computable) {
        this.c = computable;
    }

    public V compute(final A arg) throws InterruptedException {
        //根据key看缓存中有没有
        //有就获取futrue中的值
        //没有的话新建一个futrueTask任务执行
        //执行前判断下是否有其他线程已经执行了，没有就执行，有就返回
        while (true) {
            Future<V> vFuture = cache.get(arg);
            if (null == vFuture) {
                Callable<V> callable = () -> c.compute(arg);
                FutureTask<V> vFutureTask = new FutureTask<>(callable);
                //如果没有就添加，有就返回该值
                vFuture = cache.putIfAbsent(arg, vFuture);
                if (null == vFuture) {
                    vFuture = vFutureTask;
                    vFutureTask.run();
                }
            }
            try {
                return vFuture.get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

    }

}
