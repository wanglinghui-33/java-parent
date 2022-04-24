package com.dream.freedom.create.singleton;

/**
 * 设计模式--单利模式-- 内部类 实现单利模式
 *
 *      静态内部类实现模式（线程安全，调用效率高，可以延时加载）
 *
 */
public class SingletonD {

    /**
     * 私有构造函数
     */
    private SingletonD(){

    }

    public static SingletonD getInstance(){
        return SingletClassInstance.singletD;
    }

    /**
     * 内部类
     */
    private static class SingletClassInstance{
        private static final SingletonD singletD = new SingletonD();

        // 内部类可以写变量、方法
        public void mm(){

        }
    }




}
