package com.dream.freedom.recursion;


import java.util.*;



public class Combination {



    /**

     * 组合选择（从列表中选择n个组合）

     * @param dataList 待选列表

     * @param n 选择个数

     */

    public static void combinationSelect(String[] dataList, int n) {

        System.out.println(String.format("C(%d, %d) = %d", dataList.length, n, Util.combination(dataList.length, n)));

        combinationSelect(dataList, 0, new String[n], 0);

    }



    public static void combinationSelect(Integer[] dataList, int n) {

        String[] data = new String[dataList.length];

        for(int i = 0; i < dataList.length; i++) {

            data[i] = dataList[i] + "";

        }

        combinationSelect(data, n);

    }



    /**

     * 组合选择

     * @param dataList 待选列表

     * @param dataIndex 待选开始索引

     * @param resultList 前面（resultIndex-1）个的组合结果

     * @param resultIndex 选择索引，从0开始

     */

    private static void combinationSelect(String[] dataList, int dataIndex, String[] resultList, int resultIndex) {

        int resultLen = resultList.length;

        int resultCount = resultIndex + 1;

        if (resultCount > resultLen) { // 全部选择完时，输出组合结果

            System.out.println(Arrays.asList(resultList));

            return;

        }



        // 递归选择下一个

        for (int i = dataIndex; i < dataList.length + resultCount - resultLen; i++) {

            resultList[resultIndex] = dataList[i];

            combinationSelect(dataList, i + 1, resultList, resultIndex + 1);

        }

    }



}
