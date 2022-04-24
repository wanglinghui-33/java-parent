package com.dream.freedom.recursion;

/**
 * 递归算法--不断调用自己本身，递归效率比较低
 */
public class RecursionTest02 {


    /**
     * 使用递归--计算 1到n的和  就是 1+2+3+4+5.....+n
     *
     * @return
     */
    public static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sum(n - 1);
    }

    /**
     * 计算 n 的阶乘  就是 n*(n-1)*(n-2)*(n-3).....*3*2*1
     *
     * @param n
     * @return
     */
    public static int factorial(int n) {
        if (n == 2) {
            return 2;
        }
        return n * factorial(n - 1);
    }

    /**
     * 求2 的n次方，负数也是可以的
     * 运行一亿次耗时7000毫秒
     *
     * @param n 整数
     * @return 返回2的n次方的结果
     */
    public static double twoPower(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1 / (2 * twoPower(n * (-1) - 1));
        }
        return 2 * twoPower(n - 1);
    }


    /**
     * 使用位运算求2 的n次方,只要是31次方之内的都可以可以，大于等于31则不行
     * 运行一亿次耗时10毫秒
     *
     * @param n 多少次方
     * @return 返回2的n次方的结果
     */
    public static double twoPowerUseBit(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1.0 / (2 << (n * (-1) - 1));
        }
        return 2 << (n - 1);
    }


    /**
     *
     * 循环一亿次，递归耗时2200毫秒，位运算耗时10毫秒
     * 循环一千万次，递归耗时200毫秒，位运算耗时9毫秒
     *
     * 总结，不论调用多少次位运算，耗时不会增加，但是调用递归，耗时就非常严重
     */
    public void test(){
        int size = 100000000;
        long begin = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            RecursionTest02.twoPower(-8);
        }
        System.out.println("2的次方结果。递归用时：" + (System.currentTimeMillis() - begin) + "毫秒");
        long begin2 = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            RecursionTest02.twoPowerUseBit(-8);
        }
        System.out.println("2的次方。位运算用时：" + (System.currentTimeMillis() - begin2) + "毫秒");
    }


}
