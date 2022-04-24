package com.dream.freedom.sort;

/**
 * 算法--排序-- 选择排序
 * <p>
 * 选择排序，就是假设第一个是最小的，然后，用第一个和后面的做比较，如果后面发现更小的，然后用这个用更小的继续往后比较，知道比较完成
 * <p>
 * 找到最下的那个之后，用这个最下的和第一位置交换，
 * <p>
 * 进入第二循环，从第二数据开始往后比较，找出最小的，然后和第二位位置换掉，，周而复始
 */
public class SelectSort {

    public static void selectSortTest() {

        int[] arrays = {23, 2, 34, 12, 8, 3, 9};
        int count = 0;
        int count2 = 0;
        for (int i = 0; i < arrays.length - 1; i++) {
            //假设第一个最小的
            int min = i;
            for (int j = i + 1; j < arrays.length; j++) {
                count++;
                // 这个就是找出最小的那个数据，
                if (arrays[min] > arrays[j]) {
                    min = j;
                }
            }
            // 如果 min 和 i 相等，说明第一个就是最小的，则不需要替换
            // 找到的最小的和第一个是相等，说明后面有比第一个更小的， 找到后面的最小的之后，
            if (min != i) {
                count2++;
                int temp = arrays[min];
                arrays[min] = arrays[i];
                arrays[i] = temp;
            }
        }
        System.out.println("选择排序循环次数：" + count + "交换次数:" + count2);
        for (int i = 0; i < arrays.length; i++) {
            System.out.println(arrays[i]);
        }

    }
}
