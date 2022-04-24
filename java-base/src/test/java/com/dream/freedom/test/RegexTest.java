package com.dream.freedom.test;

import org.junit.Assert;
import org.junit.Test;

public class RegexTest {

    private Object object;

    /**
     * 正则测试
     */
    @Test
    public void test() throws NoSuchMethodException {


        String type = "20";
        if ("10".equals(type)) {
            System.out.println("11");
        } else if ("20".equals(type)) {
            System.out.println("11");
        } else if ("30".equals(type)) {
            System.out.println("11");
        } else if ("40".equals(type)) {
            System.out.println("11");
        }

        //Assert.assertEquals(期望值,实际值);
        // 该方法无返回值，如何校验？如果期望值和实际值相等，就正常，如果期望值和实际值不相等，则抛出异常


    }
}
