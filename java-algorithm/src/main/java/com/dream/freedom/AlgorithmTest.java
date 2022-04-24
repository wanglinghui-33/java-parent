package com.dream.freedom;

/**
 * 算法
 *
 *      算法： 递归、排序、二分查找、搜索、哈希算法、贪心算法、分治算法、回溯算法、动态规划、字符串匹配算法
 *
 */
public class AlgorithmTest {

    public static void test(){
        // 算法中会用到的位移
        // 向右位移，相当于 100 / (2的n次方) 下面的n分别是1、2、3、4
        System.out.println(100 >> 1);
        System.out.println(100 >> 2);
        System.out.println(100 >> 3);
        System.out.println(100 >> 4);

        // 向左位移，相当于 100 * (2的n次方) 下面的n分别是1、2、3、4
        System.out.println(100 << 1);
        System.out.println(100 << 2);
        System.out.println(100 << 3);
        System.out.println(100 << 4);
    }

}
