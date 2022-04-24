package com.dream.freedom.jdk.java.lang;

/**
 * 重写SUN公司的Object 原码，并注释
 *
 * 如果不显式继承Object ，默认继承java.lang.Object 类
 *
 * 被final 修饰的类不能被继承，被final修饰的变量不能重新赋值(引用类型的话，内存地址不变，可以改变内存地址指向对象的属性值)
 *
 * 被final 修复的方法 不能被重写
 *
 */
public class ObjectTest extends Object {

    /**
     * 静态代码块---类加载的时候执行，并且只执行一次
     */
    static {
        registerNatives();
    }

    /**
     *  注意：当原码中一个方法以“;”结尾，并且修饰符列表中有 native 关键字时，表示底层调用C++写的dll程序(dll 动态链接库文件)
     */
    private static native void registerNatives();

    /**
     * 这个也是调用C++ 程序
     * @return
     */
    //public final native Class<?> getClass();

    /**
     * 调用C++ ,生成hashCode ---  所谓的hash算法
     *
     * 返回该对象的hash码值
     *
     * 注：哈希值是根据哈希算法算出来的一个值，这个值跟地址有关，但不是实际地址
     *
     *      实际上就是一个java对象的内存地址，经过哈希算法，得出一个值。所以，hashCode() 方法的执行结果可以等同看做一个java对象的内存地址
     *
     * @return
     */
    public native int hashCode();

    /**
     * 用来判断 obj 和 当前对象是否相等
     *
     * equals方法的目的：
     *
     *      在以后的编程中，都要通过equals 方法来判断两个对象是否相等
     */
    public boolean equals(Object obj) {
        return (this == obj);
    }

    /**
     * 克隆 -- 把A 对象克隆 B
     * 要调用这个clone方法，要实现Cloneable 接口
     * implements Cloneable
     *
     * 克隆 --  深克隆和浅克隆
     */
    protected native Object clone() throws CloneNotSupportedException;

    /**
     * 转成字符串
     * 转换后的结果格式是：
     *  如果在项目的话：com.xxx.xxx.xxx类@16进制编码
     *  如果单独一个java文件：xxx类@16进制编码
     *
     *  Integer.toHexString(hashCode()): 对象的内存地址转换为十六进制的形式
     *
     *  作用(目的)：
     *      通过调用此方法可以将一个java 对象 转换成  字符串表示形式
     *
     */
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }

    /**
     * 调用C++ ， 被final修饰的方法不能被重写，但是可以继承
     */
    //public final native void notify();

    /**
     *
     */
    //public final native void notifyAll();

    /**
     * 被final修饰的方法不能被重写，但是可以继承
     *
     */
    /*public final void wait(long timeout, int nanos) throws InterruptedException {
        if (timeout < 0) {
            throw new IllegalArgumentException("timeout value is negative");
        }
        if (nanos < 0 || nanos > 999999) {
            throw new IllegalArgumentException(
                    "nanosecond timeout value out of range");
        }
        if (nanos > 0) {
            timeout++;
        }
        wait(timeout);
    }*/


    /**
     *
     */
    /*public final void wait() throws InterruptedException {
        wait(0);
    }*/


    /**
     * 垃圾回收器负责调用的方法
     *
     *      Object 类中，finalize() 只有方法体，里面没有代码，而且这个方法是protected修饰。
     *
     *      这个方法不需要程序员手动调用，JVM的垃圾回收器会负责调用这个方法
     *
     *      finalize()方法的执行时机：
     *          当一个Java对象即将被垃圾回收器回收时，垃圾回收器负责调用finalize() 方法
     *
     *      finalize() 是sun公司给程序员准备的一个时机，垃圾销毁时，如果你希望在对象销毁时执行一段代码，那么这段代码就要写到
     *      finalize() 方法中，
     *
     *      java 垃圾回收器不轻易启动，垃圾太少或者时间没到，种种条件下，有可能启动，也有可能不启动
     *
     *      把一个对象赋值为null时，说明这个对象就是垃圾了
     *
     *
     * @throws Throwable
     */
    protected void finalize() throws Throwable { }


    /**
     * 多创建对象，然后把对象变成垃圾，触发GC回收，调用finalize() 方法
     * 创建垃圾的测试方法
     */
    private void test(){
        for (int i =0;i<110000;i++){
            ObjectTest stu = new ObjectTest();
            System.out.println(stu.toString());
            stu = null;
        }


        ObjectTest st = new ObjectTest();
        st = null;
        System.gc();    // 这个建议启动垃圾回收器，（只是建议，垃圾少的话，可能也不会启动）
    }


}
