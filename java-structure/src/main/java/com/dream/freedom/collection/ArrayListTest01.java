package com.dream.freedom.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest01 {



    public static void test() {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        System.out.println(list.size());
    }

    public static void test2() {
        List<String> list = new ArrayList<>();

        list.add("abc");
        list.add("abc");
        list.add("abc");

        //
        Iterator it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        Iterator it2 = list.iterator();
        for (;it2.hasNext();){
            System.out.println(it2.next());
        }
    }
}
