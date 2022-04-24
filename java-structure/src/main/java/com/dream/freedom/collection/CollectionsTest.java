package com.dream.freedom.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collections 集合工具类的使用
 */
public class CollectionsTest {


    public void  m1(){
        List<String> list = new ArrayList<>();
        // ArrayList 是非线程安全的，使用Collections集合工具类，把list集合编程线程安全的
        Collections.synchronizedList(list);
        list.add("abc");
        list.add("def");

        // 这个是对集合中的元素进行排序
        // 注意：对集合中的元素排序，有个前提条件：需要保证list集合中的元素必须实现了Comparable接口，重写compareTo方法
        Collections.sort(list);

    }
}
