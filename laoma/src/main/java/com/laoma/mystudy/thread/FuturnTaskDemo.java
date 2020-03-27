package com.laoma.mystudy.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author xgh
 * @date ：Created on 2020/3/16
 */
public class FuturnTaskDemo {

    public static void main(String[] args) {
        List<String> a = new ArrayList();
        FutureTask<List<String>> task = new FutureTask<List<String>>(new FuntrueTaskDemo(a));
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
        try {
            task.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(a.toString());


    }

}

