package com.dream.freedom.collection;

import java.util.*;
import java.util.stream.Collectors;

public class DifferentListTest {

    // 前端
    public static List<RuleColumn> aList;
    // 数据库
    public static List<RuleColumn> bList;

    static {
        aList = new ArrayList<>(Arrays.asList(
                new RuleColumn(2006401, 1001L),
                new RuleColumn(2006401, 1002L),
                new RuleColumn(2006401, 1003L),
                new RuleColumn(2006401, 1004L)
        ));
        bList = new ArrayList<>(Arrays.asList(
                new RuleColumn(2006401, 1002L),
                new RuleColumn(2006401, 1003L),
                new RuleColumn(2006401, 1005L)
        ));
    }

    /**
     * 找出集合的差集
     */
    public static void diffTest() {
        // 求bList集合相对aList集合的差集
        List<RuleColumn> collect = bList.stream().filter(b -> aList.stream().map(RuleColumn::getColumnId).noneMatch(columnId -> Objects.equals(b.getColumnId(), columnId))).collect(Collectors.toList());
        System.out.println(collect);
        // 求aList集合相对bList集合的差集
        List<RuleColumn> collect2 = aList.stream().filter(a -> bList.stream().map(RuleColumn::getColumnId).noneMatch(columnId -> Objects.equals(a.getColumnId(), columnId))).collect(Collectors.toList());
        System.out.println(collect2);
    }

    public static void intersection() {
        List<RuleColumn> collect = aList.stream().filter(a -> bList.stream().map(RuleColumn::getColumnId).anyMatch(column -> Objects.equals(a.getColumnId(), column))).collect(Collectors.toList());
        System.out.println("交集：" + collect);
        // 分析上门的代码
        aList.stream()      // 获取第一集合的stream1
                .filter(    // 取出Stream1中符合条件的元素组成新的Stream2，lambda表达式1返回值为true时为符合条件
                        a ->    //lambda表达式1，a为lambda表达式1的参数，是Stream1中的每个元素
                                bList.stream()  //获取第二个集合的Stream3
                                        .map(RuleColumn::getColumnId)   //将第二个集合每个元素的columnId属性取出来，映射成新的一个Stream4
                                        .anyMatch(      //返回值（boolean）：Stream4中是否至少有一个元素使lambda表达式2返回值为true
                                            column ->   //lambda表达式2，id为lambda表达式2的参数，是Stream4中的每个元素
                                                    Objects.equals(a.getColumnId(),column)  //判断id的值是否相等
                                        )

                ).collect(Collectors.toList());//将Stream2转换为List


        // 把获取的集合转成map
        Map<Integer, List<Long>> collect1 = collect.stream().collect(Collectors.groupingBy(RuleColumn::getType, Collectors.mapping(RuleColumn::getColumnId, Collectors.toList())));
        System.out.println(collect1);
        System.out.println(collect1.get(2006401));


    }


}
