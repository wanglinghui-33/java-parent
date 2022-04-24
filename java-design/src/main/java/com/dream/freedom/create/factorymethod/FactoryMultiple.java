package com.dream.freedom.create.factorymethod;

/**
 *
 *  多个工厂方法模式: 是对普通工厂方法模式的改进，在普通工厂方法模式中，如果传递的字符串出错，则不能正确创建对象，而多个工厂方法模式是提供多个工厂方法，分别创建对象。
 *
 */
public class FactoryMultiple {

    /**
     *
     * @return 返回 Mail 实例对象
     */
    public Send produceMail(){
        return new MailSend();
    }

    /**
     *
     * @return 返回 SmsSend 实例对象
     */
    public Send produceSms(){
        return new SmsSend();
    }


}
