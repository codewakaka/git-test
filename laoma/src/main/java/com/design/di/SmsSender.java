package com.design.di;

public class SmsSender implements  MessageSender {
    @Override
    public void send(String phone, String message) {
        System.out.println("短信发送");
    }
}
