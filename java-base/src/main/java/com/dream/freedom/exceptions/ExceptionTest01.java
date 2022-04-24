package com.dream.freedom.exceptions;

/**
 * 关于finally 的一个 面试题
 */
public class ExceptionTest01 {

    public static void test() {

        int num = mm();
        System.out.println(num);
    }


    public static int mm() {
        int i = 100;
        try {
            return i;
        } finally {
            i++;
        }
    }
}
