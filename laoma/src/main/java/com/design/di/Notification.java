package com.design.di;

public class Notification {

    private  MessageSender messageSender ;

    //非依赖注入
    public Notification() {
       // this.messageSender = new MessageSender();
    }

    //依赖注入写法
    public Notification(MessageSender messageSender) {
        this.messageSender = messageSender;
    }
    public void  sendMessage(String phone ,String message) {
        this.messageSender.send(phone, message);
    }
}
