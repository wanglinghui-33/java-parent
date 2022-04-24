package com.dream.freedom.exceptions;

/**
 * 自定义异常 ，需要继承Exception
 */
public class MyTestException extends Exception {

    /**
     * 无参构造
     */
    public MyTestException() {
    }

    /**
     * 有参构造
     * @param message 异常提示信息
     */
    public MyTestException(String message) {
        super(message);
    }
}
