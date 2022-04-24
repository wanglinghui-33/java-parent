package com.dream.freedom.collection;

import com.dream.freedom.domain.TreeSetDO;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * TreeSet的介绍： TreeSet 继承 AbstractSet 实现NavigableSet 接口。NavigableSet接口 继承 SortedSet接口
 * 1、TreeSet底层是实际上是TreeMap，new TreeSet集合的时候，底层实际上是new了一个TreeMap集合
 * 2、TreeMap集合底层采用二叉树数据结构
 * 3、TreeSet 相当于是TreeMap中的key
 * 4、TreeSet可以存放String、Integer，但是不能直接存放自己创建的对象，除非该对象实现Comparable接口，并重写compareTo()方法
 * <p>
 * 放到TreeSet或者TreeMap集合key部分的元素(一般是自定义的类)要想做到排序，有两种方式
 * 第一种：放在集合中的元素要实现java.lang.Comparable 接口，需要重写compareTo方法
 * 第二种：在构造TreeSet或者TreeMap时，给它传一个比较器对象
 * Comparable和Comparator 怎么选择？
 * 如果比较规则不会发生改变的时候，或者说比较规则只有一个的时候，建议使用实现comparable接口
 * 比较规则有多个，并且需要多个规则频繁切换，建议使用Comparator接口
 */
public class TreeSetTest01 {

    /**
     * 往TreeSet添加自定义对象时，如果该对象没有实现Comparable接口并重写CompareTo方法是，是不能直接存放到TreeSet集合中的
     * 第二种方法是创建集合对象的时候，构造函数时，把比较器传过去
     */
    public void testObject2() {
        // 使用TreeSet 会自动排序，使用的数据结构是二叉树
        // 这个是在创建集合的时候，把构造器传过去  这个使用降序输出
        TreeSet<TreeSetDO> set = new TreeSet<>(new Comparator<TreeSetDO>() {
            // 这个就是匿名内部类实现接口，重写compareTo方法
            @Override
            public int compare(TreeSetDO o1, TreeSetDO o2) {
                return o2.getAge() - o1.getAge();
            }
        });
        set.add(new TreeSetDO(80, "小米"));
        set.add(new TreeSetDO(90, "笑话"));
        set.add(new TreeSetDO(30, "可爱淘"));
        set.add(new TreeSetDO(60, "小米粒"));
        set.add(new TreeSetDO(22, "王二小"));
        for (TreeSetDO treeSetDO : set) {
            System.out.println(treeSetDO);
        }
    }

    /**
     * 往TreeSet添加自定义对象时，如果该对象没有实现Comparable接口并重写CompareTo方法是，是不能直接存放到TreeSet集合中的
     * 这是第一种方法：就是该对象实现了Comparable接口重写CompareTo方法
     */
    public void testObject() {
        // 使用TreeSet 会自动排序，使用的数据结构是二叉树
        TreeSet<TreeSetDO> set = new TreeSet<>();
        set.add(new TreeSetDO(80, "王二小"));
        set.add(new TreeSetDO(90, "王二小"));
        set.add(new TreeSetDO(30, "王二小"));
        set.add(new TreeSetDO(60, "王二小"));
        set.add(new TreeSetDO(22, "王二小"));
        for (TreeSetDO treeSetDO : set) {
            System.out.println(treeSetDO);
        }
    }

    /**
     * String 、Integer 等类型已经实现了comparable接口，并重写了compareTo() 方法
     * 所以，这个TreeSet集合保存此类型时，会自动排序，按照二叉树的数据结构存储
     * 输出后：11  24  40  50  90  100  233  1100
     */
    public void testInteger() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(100);
        set.add(24);
        set.add(50);
        set.add(40);
        set.add(90);
        set.add(11);
        set.add(1100);
        set.add(233);
        for (Integer integer : set) {
            System.out.print(integer + "  ");
        }
        System.out.println();
    }

    /**
     * 这个是对String类型的数据操作，往TreSet集合添加数据，会自动排序,字符串是按照String类里面的compareTo方法进行比较排序
     * abc  abe  bce  deg  erg  hsd  niu  sex
     */
    public void testString() {
        TreeSet<String> set = new TreeSet<>();
        set.add("abc");
        set.add("bce");
        set.add("abe");
        set.add("deg");
        set.add("hsd");
        set.add("erg");
        set.add("sex");
        set.add("niu");
        for (String str : set) {
            System.out.print(str + "  ");
        }
    }

}
