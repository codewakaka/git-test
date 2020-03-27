package com.laoma.mystudy.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xgh
 * @date ：Created on 2020/3/16
 */
public class MyRunnable implements Runnable {
    List<String> list = new ArrayList();

    public MyRunnable(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        System.out.println("runable ============");
        list.add(Thread.currentThread().getName());
    }
}
