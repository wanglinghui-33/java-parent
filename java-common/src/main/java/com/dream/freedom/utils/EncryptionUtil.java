package com.dream.freedom.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * 加密的方式有哪些
 */
public class EncryptionUtil {


    /**
     * 使用JDK-Base64实现加密
     *
     * @param password 要加密的字符串
     * @return 加密后返回的密文
     */
    public static String jdkBase64Encode(String password) {
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(password.getBytes());
    }

    /**
     * JDK-base64实现解密
     *
     * @param encoder 要解码的密文
     * @return 把密文解密成常见字符串
     * @throws IOException 异常
     */
    public static String jdkBase64Decoder(String encoder) throws IOException {
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] bytes = decoder.decodeBuffer(encoder);
        return new String(bytes);
    }


}
