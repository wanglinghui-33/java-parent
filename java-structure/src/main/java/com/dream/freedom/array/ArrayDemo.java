package com.dream.freedom.array;

/**
 * 数据结果 ---  数组
 */
public class ArrayDemo {


    /**
     * 数组的定义
     */
    public static void arrayTest() {
        //静态初始化
        int[] array1 = {100, 200, 300};
        // 动态初始化
        int[] array2 = new int[5];              //初始化一个长度为5的int类型数组，默认都是0
        String[] array3 = new String[3];        //初始化一个长度为5的String类型数组，默认都是null
        //方式一
        arrayOne(array1);
        arrayOne(new int[]{100, 200, 300});   //如果想直接赋值数组，则需要带new int[]
        arrayOne(array2);
    }

    public static void arrayOne(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    /**
     * 数组拷贝
     */
    public static void arrayKuo() {
        int[] nums = {1, 2, 3, 4};
        int[] newNums = new int[10];
        /**
         * 拷贝源
         * 拷贝位置--就是从哪个位置开始拷贝
         *
         * 新数组源
         * 新数组拷贝位置--就是从哪个位置开始保存数据--- 这个拷贝位置要小于新数组源的长度-拷贝的长度
         *
         * 拷贝的长度---就是要拷贝多少个数据--- 这个长度不能大于拷贝源的长度-拷贝位置
         */
        System.arraycopy(nums, 0, newNums, 6, 4);
        for (int i = 0; i < newNums.length; i++) {
            System.out.println(newNums[i]);
        }
    }


}
