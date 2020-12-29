package com.laoma.mystudy.thread;

import com.laoma.mystudy.lambda.Student;

import java.util.concurrent.Exchanger;

/**
 * @author xgh
 * @date ：Created on 2020/12/29
 */
public class TheradException {

    public static void main(String[] args) throws InterruptedException {
        Exchanger<Exception> ex = new Exchanger<>();
        Therad1 therad1 = new Therad1(ex);
        therad1.start();
        new Therad2(ex).start();

        System.out.println(therad1.getEx());
    }

    static class Therad1 extends Thread {
        Exchanger<Exception> ex;
        public Therad1(Exchanger<Exception> ex) {
            this.ex = ex;
        }
        @Override
        public void run() {
            try {
                System.err.println("交换前的thread1的 e" + ex);
                int i = 1 / 0;
            } catch (Exception e) {
                try {
                    Exception exchange = ex.exchange(e);
                    System.err.println("交换后的thread1的 e " + exchange);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }

        }

        public Exchanger<Exception> getEx() {
            return ex;
        }
    }
    static class Therad2 extends Thread {
        Exchanger<Exception> ex;
        public Therad2(Exchanger<Exception> ex) {
            this.ex = ex;
        }
        @Override
        public void run() {
            try {
                System.err.println("交换前的thread2的 e " + ex);
                Student s = null;
                s.getName();
            } catch (Exception e) {
                try {
                    Exception exchange = ex.exchange(e);
                    System.err.println("交换后的thread2的 e " + exchange);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }

        }
    }
}
