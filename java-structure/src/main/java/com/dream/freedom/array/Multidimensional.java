package com.dream.freedom.array;

import com.alibaba.fastjson.JSONArray;

/**
 * 多维数组
 */
public class Multidimensional {


    public static void main(String[] args) {
        test();
    }

    public static void test() {


        String one = "[\"2000401\",\"2000402\"]";
        String two = "[[\"2000400\",\"2000401\"],[\"2000400\",\"2000402\"]]";

        System.out.println(one.getClass());


        JSONArray jsonArray = JSONArray.parseArray(one);


        for (int i = 0; i < jsonArray.size(); i++) {
            // System.out.println(jsonArray.get(i));
            /*JSONObject object= (JSONObject) jsonArray.get(i);
            System.out.println(object);*/
        }

        JSONArray jsonArray2 = JSONArray.parseArray(two);

        for (int i = 0; i < jsonArray2.size(); i++) {
            System.out.println(jsonArray2.get(i));

            // 二维数组
            JSONArray ddd = JSONArray.parseArray(jsonArray2.get(i).toString());

            System.out.println(ddd.get(1));
            /*for (int j = 0; j < ddd.size(); j++) {
                System.out.println(ddd.get(j));
            }*/
        }


    }

}
