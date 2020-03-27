package com.laoma.mystudy.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author xgh
 * @date ：Created on 2020/3/16
 */
public class ThreadPoolDemo {



    public static void main(String[] args) {
        List<String>  a = new ArrayList<>();
       /* ExecutorService service = Executors.newCachedThreadPool();
        Future<List<String>> f = service.submit(new FuntrueTaskDemo(a));
        try {
            System.out.println(f.get().toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            service.shutdown();
        } */
      /*  BlockingDeque<Runnable>  linkedBlockingDeque = new LinkedBlockingDeque();
        linkedBlockingDeque.add(new MyRunnable(a));
        linkedBlockingDeque.add(new MyRunnable(a));
        linkedBlockingDeque.add(new MyRunnable(a));
        linkedBlockingDeque.add(new MyRunnable(a));
        ThreadPoolExecutor pool = new ThreadPoolExecutor(10,15,2,TimeUnit.SECONDS,linkedBlockingDeque);
        for (int i=0;i<100;i++) {
            Future<List<String>> submit = pool.submit(new FuntrueTaskDemo(a));
        }*/
        List sss = new ArrayList();
        sss.stream().distinct();


    }
}
