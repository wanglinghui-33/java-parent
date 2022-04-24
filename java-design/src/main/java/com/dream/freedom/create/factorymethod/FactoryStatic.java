package com.dream.freedom.create.factorymethod;

/**
 *  静态工厂方法模式，将上面的多个工厂方法模式里的方法置为静态的，不需要创建实例，直接调用即可。
 */
public class FactoryStatic {

    public static Send produceMail(){
        return new MailSend();
    }

    public static Send produceSms(){
        return new SmsSend();
    }

}
