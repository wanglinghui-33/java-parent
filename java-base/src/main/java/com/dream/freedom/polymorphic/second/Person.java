package com.dream.freedom.polymorphic.second;

/**
 * 人类
 */
public class Person {

    /**
     * 公开的——任何位置都可以访问
     */
    public String name;

    /**
     * 受保护的——在同包、子类 都可以访问
     */
    protected String happy = "小米";

    /**
     * 缺省的——只有在同包下才能访问
     */
    String job;

    /**
     * 私有的——只能在本类中访问
     */
    private int age;

    public Person(){

    }

    public Person(String name, String happy, String job, int age) {
        this.name = name;
        this.happy = happy;
        this.job = job;
        this.age = age;
    }

    public void m1(){

    }

    protected void m2(){

    }
    void m3(){

    }


}
