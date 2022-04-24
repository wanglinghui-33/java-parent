package com.dream.freedom.create.singleton;

/**
 * 设计模式--单利模式--懒汉式
 *
 *     当第一次去使用Singleton对象的时候才会为其产生实例化对象的操作(线程不安全，调用效率不高，但是能延时加载)
 *
 *          优点：需要时才去创建
 *
 *          缺点：没有考虑线程安全问题，多个线程并发调用getInstance，可能会创建多个实例
 *
 *      当多个线程并发执行 getInstance 方法时，懒汉式会存在线程安全问题，所以用到了 synchronized 来实现线程的同步，
 *
 *      当一个线程获得锁的时候其他线程就只能在外等待其执行完毕。而饿汉式则不存在线程安全的问题。
 *
 *
 *      写过多线程并发调用该实例，测试是否创建多个实例
 */
public class SingletonB {

    /**
     * 声明变量
     */
    private static SingletonB singletonB = null;

    /**
     * 私有构造--写一个私有构造，创建对象的时候就不用实例化了
     */
    private SingletonB() {
        System.out.println("创建对象，并且只被执行一次" );
    }

    /**
     * 错误写法一：如果多个线程并行调用,就会创建多个实例
     */
    public static SingletonB getInstanceA() {
        if (singletonB == null) {
            singletonB = new SingletonB();
        }
        return singletonB;
    }

    /**
     * 错误写法二：这样写也存在线程安全问题，如果多个线程并行，依然会创建多个实例,在锁等待完成之后还是创建了对象
     */
    public static SingletonB getInstanceB() {
        if (singletonB == null) {
            synchronized (SingletonB.class) {
                singletonB = new SingletonB();
            }
        }
        return singletonB;
    }

    /**
     * 方法三：正确创建单利对象，方法上使用synchronized 锁
     *
     *      当多个线程并发执行getInstanceB方法时，懒汉式会存在线程安全的问题，所以要用到synchronized来实现线程的同步，
     *
     *      当一个线程获得锁的时候，其他线程只能在外等待执行完毕。
     *
     * @return
     */
    public static synchronized SingletonB getInstanceC(){
        if (singletonB == null){
            singletonB = new SingletonB();
        }
        return singletonB;
    }


    public void print(){
        System.out.println("懒汉式单利模式---Hello World");
    }

}
