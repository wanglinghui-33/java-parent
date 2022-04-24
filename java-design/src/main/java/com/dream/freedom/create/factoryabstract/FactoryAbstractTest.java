package com.dream.freedom.create.factoryabstract;

import com.dream.freedom.create.factorymethod.Send;

public class FactoryAbstractTest {


    public static void factoryAbstractTest(){


        // 多态机制
        Provide pro = new MailFactory();
        Send send = pro.produce();
        send.send();

        // 调用Sms
        pro = new SmsFactory();
        pro.produce().send();

        MailFactory.produce1().send();

    }


}
