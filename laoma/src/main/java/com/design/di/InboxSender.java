package com.design.di;

public class InboxSender implements  MessageSender {
    @Override
    public void send(String phone, String message) {
        System.out.println("站内信息发送--");
    }
}
