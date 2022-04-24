package com.dream.freedom.create.factoryabstract;

import com.dream.freedom.create.factorymethod.MailSend;
import com.dream.freedom.create.factorymethod.Send;

/**
 *  这里也可以定义静态方法
 */
public class MailFactory implements Provide {

    /**
     *  定义静态方法也是可以的
     * @return
     */
    public static Send produce1() {
        System.out.println("静态方法调用此方法，返回MailSend 对象");
        return new MailSend();
    }

    /**
     * @return 返回MailSend 对象
     */
    public Send produce() {
        System.out.println("调用此方法，返回MailSend 对象");
        return new MailSend();
    }

}
