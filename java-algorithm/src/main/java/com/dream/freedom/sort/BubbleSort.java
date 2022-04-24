package com.dream.freedom.sort;

/**
 * 算法---冒泡排序：
 * <p>
 * 1、每一次循环结束之后，都会找出最大的数据，放到参与比较的这堆数据的最右边，(冒出最大的那个气泡)
 * <p>
 * 2、核心：拿着左边的数据和右边的数据做对比，当左边 > 右边 的时候，交换位置。
 *
 * 3、冒泡排序，就是两两相比，大的往后推移，一直推移到最后一个
 */
public class BubbleSort {

    /**
     * 冒泡排序 -- 双循环的次数 =  数组的长度-1 + (数组的长度-2) +  ....+ 1
     */
    public static void bubbleTest() {
        int[] array = {23, 2, 34, 12, 8, 3, 9};
        int count = 0;
        int count2 = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                count++;
                if (array[j] > array[j + 1]) {
                    count2++;
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println("冒泡排序循环次数：" + count + "交换次数:" + count2);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void bubbleTest2() {
        int[] array = {23, 2, 34, 12, 8, 3};
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }


}
