package com.dream.freedom.binary;

/**
 * 二分法查找--把要查找的数组一分为二
 * <p>
 * 二分法查找，是建立在排序的基础上{1,2,4,6,7,9,12,15,45,67}， 没有排序的数据是不能使用二分法的
 * <p>
 * 二分法，是找到第一个元素的下标和最后一个元素的下标，然后相加除以2，得出中间的下标，然后用这个下标和要找的元素做对比，
 * <p>
 * 如果这个中间元素比要找的元素大，则目标元素在左边，继续折半去查找，二分法查找效率比较高
 */
public class BinarySearch {

    int[] array = {100, 200, 300, 400, 500, 600, 666, 680, 800, 900};
    int num = 200;


    /**
     * 使用二分法 在有序的数组中找到指定的数值，并返回当前下标，如果不存在返回-1
     * 原理就是：
     * 每次都找中间的，然后第要找的数字做对比，如果相等，就直接返回
     * 如果没有找到，如果要找的数字比 当前数字大，则说明还需要往右查找
     * 否则往左右查找
     *
     * @param array 需要查询的数组
     * @param num   查找此数字
     */
    public static int binaySearchTest(int[] array, int num) {
        int begin = 0;
        int end = array.length;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (array[mid] == num) {
                return mid;
            } else if (array[mid] < num) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }


}
