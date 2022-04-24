package com.dream.freedom.test.encryption;

import com.dream.freedom.utils.EncryptionUtil;
import org.junit.Test;

import java.io.IOException;

public class EncryptionTest {

    @Test
    public void test() {

        int[] arrry2 = new int[5];
        System.out.println(arrry2.length);

        String password = "test123456";
        System.out.println(password.getBytes());
        String s = EncryptionUtil.jdkBase64Encode(password);
        System.out.println("正常：" + password + "。加密后：" + s);
        try {
            String s1 = EncryptionUtil.jdkBase64Decoder(s);
            System.out.println("密文：" + s + "。解密后：" + s1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
