package com.dream.freedom.create.factorymethod;

public class MailSend implements Send {

    @Override
    public void send() {
        System.out.println("this is Mail send message");
    }
}
