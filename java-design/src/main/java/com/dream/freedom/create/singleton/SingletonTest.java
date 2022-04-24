package com.dream.freedom.create.singleton;

/**
 * 设计模式--单利模式：
 *
 *      所谓的单利模式是指一个类只允许产生一个实例化对象，最好理解的一种设计模式，分为懒汉式和饿汉式。 构造方法都是私有化
 *
 *
 *      饿汉式：构造方法私有化，外部无法产生新的实例化对象，只能通过static方法取得实例化对象,(线程安全，调用效率高，但是不能延时加载)
 *
 *      懒汉式：当第一次去使用Singleton对象的时候才会为其产生实例化对象的操作(线程安全，调用效率不高，但是能延时加载)
 *
 *      Double CheckLock实现单例：DCL也就是双重锁判断机制（由于JVM底层模型原因，偶尔会出问题，不建议使用，加了volition关键字后，就没有问题了）
 *
 *      静态内部类实现模式（线程安全，调用效率高，可以延时加载）
 *
 *      枚举类（线程安全，调用效率高，不能延时加载，可以天然的防止反射和反序列化调用）
 *
 *
 *
 *      如何选用：
 *
 *          -单例对象 占用资源少，不需要延时加载，枚举 好于 饿汉
 *
 *          -单例对象 占用资源多，需要延时加载，静态内部类 好于 懒汉式
 *
 *
 */
public class SingletonTest {

    public static void singleTest(){


        System.out.println(SingletonE.INSTANCE.toString());
        System.out.println(SingletonE.INSTANCE.toString());
        SingletonE.INSTANCE.print();


    }
}
