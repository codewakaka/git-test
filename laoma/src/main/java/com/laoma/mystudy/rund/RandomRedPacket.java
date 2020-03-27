package com.laoma.mystudy.rund;

import java.util.Random;

public class RandomRedPacket {
    private int leftMoney;
    private int leftNum;
    private Random rand;

    public RandomRedPacket(int total,int num){
        this.leftMoney = total;
        this.leftNum = num;
        rand = new Random();
    }

    public synchronized int nextMOney(){
        if(this.leftNum <= 0){
            throw new IllegalStateException("抢完了");
        }
        if(this.leftNum == 1){
            this.leftNum --;
            return this.leftMoney;
        }
        //2倍红包法 [0-2*平均值]
        double max = this.leftMoney/this.leftNum *2d;
        int money = (int)(rand.nextDouble() *max);
        money = Math.max(1,money);
        this.leftMoney -= money;
        this.leftNum -- ;
        return money;
    }

    public static void main(String[] args) {
        RandomRedPacket r = new RandomRedPacket(1000,10);
        for (int i = 0; i <18 ; i++) {
            System.out.println(r.nextMOney());
        }
    }

}
