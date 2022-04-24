package com.dream.freedom.polymorphic.first;

/**
 * java面向对象的三大特征- 多态
 */
public class Animal {

    public float num;
    String happy;
    private String name;
    private boolean isSex;
    private char c;         // 默认值是 \u0000


    public Animal() {
        //System.exit(0);     //退出虚拟机
    }

    public Animal(String name,String happy) {
        this.name = name;
        this.happy = happy;
        System.out.println("Animal 的有参构造方法");
    }

    // 移动
    public static void move() {
        System.out.println("动物在移动");

    }

    // 吃饭
    public void eat() {
        System.out.println("动物在吃饭");
    }

    public final void m(){
        System.out.println("final 方法");
    }



}
