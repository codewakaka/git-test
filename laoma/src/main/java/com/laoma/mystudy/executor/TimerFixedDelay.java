package com.laoma.mystudy.executor;

import java.util.Timer;
import java.util.TimerTask;

public class TimerFixedDelay {
    static class LongRuningTask extends TimerTask{
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("long task finished");
        }
    }
    static class FixedDelayTask extends TimerTask{
        @Override
        public void run() {
            System.out.println("Fixed");
            System.out.println(System.currentTimeMillis());
        }
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new LongRuningTask(),10);
      // timer.schedule(new FixedDelayTask(),100,1000);
        timer.scheduleAtFixedRate(new FixedDelayTask(),100,1000);
    }
}
