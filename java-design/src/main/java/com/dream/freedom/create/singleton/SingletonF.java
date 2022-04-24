package com.dream.freedom.create.singleton;

/**
 * 我自己使用的静态代码块，实现单利---也是在类加载的时候执行，没有线程安全问题
 */
public class SingletonF {


    /**
     * 声明变量
     */
    private static SingletonF singletonF;


    /**
     * 私有化的目的就是让外面无法访问
     */
    private SingletonF() {
        System.out.println("创建对象，并且只被执行一次");
    }

    static {
        singletonF = new SingletonF();
    }

    public static SingletonF getInstance() {
        System.out.println("返回对象");
        return singletonF;
    }
}
