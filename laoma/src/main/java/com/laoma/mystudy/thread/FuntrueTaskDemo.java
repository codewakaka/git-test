package com.laoma.mystudy.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author xgh
 * @date ：Created on 2020/3/16
 */
public class FuntrueTaskDemo implements Callable<List<String>> {

    private List<String> list = new ArrayList<>();

    public FuntrueTaskDemo(List<String> list) {
        this.list = list;
    }

    @Override
    public List<String> call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        list.add(Thread.currentThread().getName());
        return list;
    }
}
