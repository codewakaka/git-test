package com.design.di;

//DI Framework
public class Demon {

    public static void main(String[] args) {
        MessageSender smsSender = new SmsSender();
        Notification notification = new Notification(smsSender);
        notification.sendMessage("11","22");
    }
}
