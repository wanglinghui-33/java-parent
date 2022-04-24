package com.dream.freedom.collection;

/**
 * 泛型，泛型可以自定义
 * <p>
 * 1、自定义泛型，<> 尖括号内的是一个标识符，可以任意写
 * 2、Java中常用的泛型是 <E> 和 <T>
 * 3、E 是Element的首字母
 * T 是 Type 的首字母
 */
public class GenericTest<E> {

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    transient Object[] elementData;

    public GenericTest() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public E get(int index) {
        return (E) elementData[index];
    }

    public void doSome(int index,E o) {
        E oldValue = (E) elementData[index];

        System.out.println("对泛型做操作");
    }
}
