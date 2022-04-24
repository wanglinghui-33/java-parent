package com.dream.freedom.create.factorymethod;

public class FactoryTest {

    public static void factoryTest() {

        System.out.println("-------------普通工厂的调用----------------");
        // 普通工厂
        Send send = FactoryOrdinary.produce("mail");
        send.send();
        send = FactoryOrdinary.produce("sms");
        send.send();


        System.out.println("-------------多个工厂的调用----------------");
        //多个工厂的调用
        FactoryMultiple factory = new FactoryMultiple();
        // 获取具体的工厂信息
        Send sendMail = factory.produceMail();
        Send sendSms = factory.produceSms();
        sendMail.send();
        sendSms.send();


        System.out.println("-------------静态工厂的调用----------------");
        //静态工厂的调用
        FactoryStatic.produceMail().send();
        FactoryStatic.produceSms().send();


    }
}
