package com.dream.freedom.collection;

import com.alibaba.fastjson.JSONArray;
import com.dream.freedom.domain.Item;
import com.dream.freedom.domain.UserInfo;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListTest02 {

    public static List<UserInfo> list;

    // 类加载的时候执行
    static {
        // 初始化集合数据
        list = new ArrayList<>(Arrays.asList(
                new UserInfo(1, "abc", 10, 1, 170),
                new UserInfo(2, "bcd", 20, 2, 180),
                new UserInfo(3, "cdf", 10, 1, 172),
                new UserInfo(4, "小米", 20, 2, 185),
                new UserInfo(5, "华为", 10, 1, 174),
                new UserInfo(6, "测试", 20, 2, 190),
                new UserInfo(7, "大米", 30, 1, 176),
                new UserInfo(8, "金刚", 40, 2, 195),
                new UserInfo(8, "金刚", 40, 2, 195)
        ));
    }

    public static void testInfo() {
        System.out.println(list.size());
        List<UserInfo> info = list.stream().distinct().collect(Collectors.toList());
        System.out.println(info.size());
        System.out.println(info);
    }

    public static void test() {
        //list.stream().map(UserInfo::getHeight).reduce((aDouble, aDouble2) -> aDouble2.doubleValue());
        //System.out.println(list.stream().map(UserInfo::getHeight).reduce((aDouble, aDouble2) -> aDouble));
        // 根据性别分组

        //
        System.out.println("----------------------------------------------------------------------");

        System.out.println("-----------------------根据年龄分组-----------------------------------------------");
        Map<Integer, List<UserInfo>> map = list.stream().collect(Collectors.groupingBy(UserInfo::getSex));
        System.out.println(map);

        System.out.println("------------------- 先过滤再获取集合 -----------------------------------");
        List info = list.stream().filter(userInfo -> userInfo.getName().contains("4")).collect(Collectors.toList());
        System.out.println(info);

        System.out.println("-------------------------------根据分组性别，然后获取年龄信息---------------------------------------");
        Map<Integer, IntSummaryStatistics> map2 = list.stream()
                .collect(Collectors.groupingBy(UserInfo::getSex, Collectors.summarizingInt(UserInfo::getAge)));
        // 先根据性别分组，然后，获取年龄的组合信息（记录数、最小值、平均值、最大值）
        // {
        // 1=IntSummaryStatistics{count=4, sum=60, min=10, average=15.000000, max=30},
        // 2=IntSummaryStatistics{count=4, sum=100, min=20, average=25.000000, max=40}
        // }
        //  map2.get(1).getMax(); 获取最大值
        System.out.println(map2);
        // 遍历分组后的map
        map2.forEach((key, intSummaryStatistics) -> System.out.println("最大值" + intSummaryStatistics.getMax()));


    }


    public static void listFilter() {
        List<UserInfo> info = list.stream().filter(userInfo -> userInfo.getHeight() > 174).collect(Collectors.toList());
        System.out.println(JSONArray.toJSON(info));
        System.out.println("=========================================================================================");
        System.out.println(list.stream().filter(u -> u.getSex() == 0 && u.getHeight() >= 175).collect(Collectors.toList()));
        System.out.println(list.stream().filter(u -> u.getSex() == 0 && u.getHeight() >= 175).collect(Collectors.toList()).size());
    }


    public static void listTest() {

        /*
        *
        * summarizingDouble 统计数据(double)状态, 其中包括count min max sum和平均值
            summarizingInt 统计数据(int)状态, 其中包括count min max sum和平均值
            summarizingLong 统计数据(long)状态, 其中包括count min max sum和平均值.

            summingInt 求和 返回int类型
            summingDouble 求和 返回double类型
            summingLong 求和 返回long类型

            counting 返回Stream的元素个数

            averagingDouble 求平均值 返回double类型
            averagingInt 求平均值 返回int类型
            averagingLong 求平均值 返回long类型

            maxBy 在指定条件下,返回最大值
            minBy 在指定条件下,返回最小值
        *
        * */

        //求和
        double sum = list.stream().mapToDouble(UserInfo::getAge).sum();
        System.out.println(sum);

        //最大值
        double max = list.stream().mapToDouble(UserInfo::getAge).max().getAsDouble();
        System.out.println("最大值：" + max);
        //最小值
        System.out.println("最小值：" + list.stream().mapToDouble(UserInfo::getAge).min().getAsDouble());
        //平均值
        System.out.println("平均值：" + list.stream().mapToDouble(UserInfo::getAge).average().getAsDouble());
        // list.stream 的数量
        System.out.println(list.stream().mapToDouble(UserInfo::getAge).count());

        System.out.println(list.stream().mapToInt(UserInfo::getSex).count());

        System.out.println("多个值：" + list.stream().collect(Collectors.summarizingDouble(UserInfo::getAge)));
        System.out.println(list.stream().collect(Collectors.summarizingDouble(UserInfo::getAge)).getMax());


    }

    /**
     * 分组、计数、排序
     */
    public static void groupCountOrder() {
        //3 apple, 2 banana, others 1
        List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");
        Map<String, Long> result =
                items.stream().collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );
        // {papaya=1, orange=1, banana=2, apple=3}
        System.out.println(result);

        // 添加到一个map中  排序
        Map<String, Long> finalMap = new LinkedHashMap<>();
        result.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue()
                        .reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
        // {apple=3, banana=2, papaya=1, orange=1}
        System.out.println(finalMap);


    }

    public static void groupByName() {
        //3 apple, 2 banana, others 1
        List<Item> items = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orange", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99"))
        );

        // 按名称分组，并计算个数
        Map<String, Long> counting = items.stream().collect(Collectors.groupingBy(Item::getName, Collectors.counting()));
        // {papaya=1, banana=2, apple=3, orange=1, watermelon=1}
        System.out.println(counting);

        // 按名称分组，并统计分组后的总重量(qty)
        Map<String, Integer> sum = items.stream().collect(Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQty)));
        // {papaya=20, banana=30, apple=40, orange=10, watermelon=10}
        System.out.println(sum);
    }

    public static void groupByPrice() {
        //3 apple, 2 banana, others 1
        List<Item> items = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orange", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99"))
        );

        //group by price
        // 按价格分组的集合
        Map<BigDecimal, List<Item>> groupByPriceMap = items.stream().collect(Collectors.groupingBy(Item::getPrice));
        /**
         * {
         *  19.99=[
         *      Item(name=banana, qty=20, price=19.99),
         *      Item(name=banana, qty=10, price=19.99)
         *     ],
         *
         *  29.99=[
         *      Item(name=orange, qty=10, price=29.99),
         *      Item(name=watermelon, qty=10, price=29.99)
         *     ],
         *
         *  9.99=[
         *      Item(name=apple, qty=10, price=9.99),
         *      Item(name=papaya, qty=20, price=9.99),
         *      Item(name=apple, qty=10, price=9.99),
         *      Item(name=apple, qty=20, price=9.99)
         *     ]
         * }
         */
        System.out.println(groupByPriceMap);

        // group by price, uses 'mapping' to convert List<Item> to Set<String>
        // 按价格分组，然后 把对应的名称放入到set 集合中
        Map<BigDecimal, Set<String>> result =
                items.stream().collect(
                        Collectors.groupingBy(Item::getPrice,
                                Collectors.mapping(Item::getName, Collectors.toSet())
                        )
                );
        // {19.99=[banana], 29.99=[orange, watermelon], 9.99=[papaya, apple]}
        System.out.println(result);


    }
}
