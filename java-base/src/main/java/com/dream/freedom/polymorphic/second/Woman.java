package com.dream.freedom.polymorphic.second;

/**
 * 妇女类
 */
public class Woman {


    /**
     * 受保护的——在同包、子类 都可以访问
     */
    protected String name = "小米";

    /**
     * 缺省的——只有在同包下才能访问
     */
    int age;

    public Woman() {
    }

    public Woman(String name, int age) {
        this.name = name;
        this.age = age;
    }



    
    
}
