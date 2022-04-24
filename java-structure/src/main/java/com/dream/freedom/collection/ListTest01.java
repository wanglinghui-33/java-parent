package com.dream.freedom.collection;

import java.util.HashSet;
import java.util.Set;

public class ListTest01 {

    /**
     * 找两个集合的交集 --- 找共同的数据
     */
    public static void intersection() {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        set1.add("a");
        set1.add("b");
        set1.add("c");

        set2.add("c");
        set2.add("d");
        set2.add("e");

        //交集
        set1.retainAll(set2);
        System.out.println("交集是 " + set1);  //交集是 [c]
    }

    /**
     * 找并集 -- 把两个集合去重之后合并
     */
    public static void unionSet() {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        set1.add("a");
        set1.add("b");
        set1.add("c");

        set2.add("b");
        set2.add("c");
        set2.add("d");

        set1.addAll(set2);
        System.out.println("并集是" + set1); //并集是[a, b, c, d]
    }

    /**
     * 找差集 --- 集合1 相对集合2 的差集， 也可以是集合2 相对集合1 的差集
     */
    public static void differenceSet() {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        set1.add("a");
        set1.add("b");
        set1.add("c");
        set1.add("d");

        set2.add("c");
        set2.add("d");
        set2.add("e");
        set2.add("f");

        //set1.removeAll(set2);
        //System.out.println("差集是 " + set1); //差集是 [a, b]

        // 反过来
        set2.removeAll(set1);
        System.out.println("set2和set1的差集" + set2);

    }
}
