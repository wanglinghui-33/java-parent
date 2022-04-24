package com.dream.freedom.create.singleton;

/**
 * 设计模式--单利模式-- 饿汉式
 *
 *      外部无法产生新的实例化对象，只能通过static方法取得实例化对象（就是第一次用的时候才会创建实例对象）
 *
 *          优点：类加载的时候创建一次实例，避免了多线程同步问题
 *
 *          缺点：即使单例没被用到也会创建，浪费内存
 */
public class SingletonA {

    /**
     * 程序初始化的时候就被加载了
     *
     * 在类的内部可以访问私有结构，所以可以在类的内部产生实例化对象
     */
    private static SingletonA singletonA = new SingletonA();

    /**
     * 构造方法--私有化
     */
    private SingletonA(){
        System.out.println("饿汉式构造，只执行一次");
    }

    public static SingletonA getInstance(){
        System.out.println("饿汉式单利模式-类加载的时候就加载了");
        return singletonA;
    }
}
