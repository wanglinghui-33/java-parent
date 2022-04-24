package com.dream.freedom.create.factorymethod;

public class SmsSend implements Send {

    @Override
    public void send() {
        System.out.println("this is SMS send message");
    }
}
