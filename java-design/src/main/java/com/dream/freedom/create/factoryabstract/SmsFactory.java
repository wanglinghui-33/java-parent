package com.dream.freedom.create.factoryabstract;

import com.dream.freedom.create.factorymethod.Send;
import com.dream.freedom.create.factorymethod.SmsSend;

public class SmsFactory implements Provide {

    /**
     * @return 返回SmsSend 对象
     */
    public Send produce() {
        System.out.println("返回SmsSend 对象");
        return new SmsSend();
    }
}
