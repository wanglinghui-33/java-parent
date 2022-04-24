package com.dream.freedom.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * list 初始化的几种方式
 */
public class ListInitMode {


    public static void main(String[] args) {
        initListData();
    }

    /**
     * list 集合初始化数据
     */
    public static void initListData() {
        // 第一种：常规方式
        List<String> stringList = new ArrayList<>();
        stringList.add("abc");
        stringList.add("abc");
        System.out.println(stringList);


        // 第二种：Arrays工具类,这种方法生成的 listTwo 不可变
        List<String> listTwo = Arrays.asList("小米", "华为", "科技");
        // 直接添加数据，会报错：java.lang.UnsupportedOperationException
        // listTwo.add("abc");  listTwo.set(3,"融创科技");
        System.out.println(listTwo);
        // 如果想可变，需要用ArrayList包装一下
        List<String> listTwo_other = new ArrayList<>(Arrays.asList("123", "345"));
        // 这个就可以继续添加
        listTwo_other.add("789");
        System.out.println(listTwo_other);


        // 第三种： Collections 工具类
        // 这种方式生成的集合不可变， 这个是添加n个重复的数据
        List<String> listThree = Collections.nCopies(4, "相同的数据");
        // 如果想可变，第二种方法
        List<String> listThree_other = new ArrayList<>(Collections.nCopies(4, "相同的数据"));
        System.out.println(listThree + ":" + listThree_other);

        /*
            第4中方式： java8 Stream
         */
        List<String> list_four = Stream.of("abc", "123", "这样也可以").collect(Collectors.toList());


        /*
            第5种： 匿名内部类
         */
        List<String> list_five = new ArrayList<String>() {{
            add("123");
            add("info");
            add("测试");
        }};

        /*
            第6种 ImmutableList 是不是需要导入别的jar包
         */
        //List list = ImmutableList.of("1", "2", "3");
        //System.out.println("getList6: " + list);

        /*
            第7种 Lists工具类 是不是需要导入别的jar包
         */
        //List list = Lists.newArrayList("1", "2", "3");
        //System.out.println("getList4: " + list);

        /*
            第8种：java9的 List.of
         */
        //List info = List.of{"1", "2", "3"};
        //System.out.println("getList8: " + list);


    }

}
