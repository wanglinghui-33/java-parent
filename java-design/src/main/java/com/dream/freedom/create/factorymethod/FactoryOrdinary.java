package com.dream.freedom.create.factorymethod;

/**
 * 普通工厂模式，就是创建一个工厂类，对实现了同一接口的一些类进行 实例的创建
 */
public class FactoryOrdinary {

    public static Send produce(String str) {
        if ("mail".equals(str)) {
            return new MailSend();
        } else if ("sms".equals(str)) {
            return new SmsSend();
        }
        System.out.println("其他类型都返回null");
        return null;
    }

}
