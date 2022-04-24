package com.dream.freedom.jdk.java.lang;

/**
 * 如果进行大量字符串拼接是，建议使用jdk自带的StringBuffer 或 StringBuilder
 *
 * 优化StringBuffer的性能：
 *      1、StringBuffer 在创建的时候尽可能给定一个初始化容量，
 *      2、最好减少底层数组的扩容，预估一下，尽可能给一个大的初始化容量
 */
public class StringBufferTest {

    public static void bufferTest01() {
        StringBuffer stringBuffer = new StringBuffer();
    }


}
