package com.dream.freedom.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 学习Collection的contains方法
 * <p>
 * 因为集合里面放的都是引用，所以，在contains原码中可以看到，判断是否包含采用的是equals来判断的，如果存放字符串，不论直接创建还是new，
 * 只要内容一样，则返回true，
 * <p>
 * 如果自己新的一个对象，new了两个相同的对象，一个放集合里面，然后用集合contains另一个对象，在该对象没有重写equals方法是，不会返回true，
 * 因为新建的对象，地址都是不一样的，没有重写equals方法，则默认调用父类Object的equals方法，是==判断的，比较的是值
 */
public class CollectionTest02 {


    public static void containsTest() {
        Collection collection = new ArrayList();
        collection.add("abc");
        collection.add("def");
        collection.add(new Object());
        collection.add(new ListDO(100, new String("王二小")));
        collection.add("小米");
        Object y = new Object();
        ListDO x = new ListDO(100, new String("王二小"));
        String z = new String("abc");
        System.out.println(collection.contains(x));
        System.out.println(collection.contains(y));
        System.out.println(collection.contains(z));
        System.out.println(collection.contains(null));
        System.out.println(collection.size());
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        //collection.remove(null);
        collection.remove("小米");
        System.out.println(collection.size());
        iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * 如果创建集合，先创建迭代器，再往集合加入数据，循环遍历时，会报错
     */
    public static void test02(){
        Collection cll = new ArrayList();
        Iterator iterator = cll.iterator();
        ((ArrayList) cll).add(100);
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
