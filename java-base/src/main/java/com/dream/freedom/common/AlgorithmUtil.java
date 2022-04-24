package com.dream.freedom.common;

public class AlgorithmUtil {

    /**
     * 2 的n次方
     * @param n 具体数据
     * @return 返回2 的n 次方
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
}
