package com.dream.freedom.polymorphic.first;

/**
 * Cat 类继承Animal
 *
 * 子类可以继承除了构造方法之外的所有方法
 *
 * 父类的静态方法，子类可以继承，但是不能重写，如果子类也写了和父类一样的静态方法，也是属于子类独有的方法
 */
public class Cat extends Animal{


    private final String name;
    private int age;

    public Cat() {
        super();    //可以省略
        System.out.println("Cat 的无参构造方法");
        name = "小米";
    }

    public Cat(String happy) {
        super("小孩",happy);    //可以省略
        this.age = age;
        System.out.println(this.happy);
        name = "小米";
    }

    public static void move(){
        System.out.println("猫在移动");
    }

    @Override
    public void eat() {
        //super.eat();
        System.out.println("猫在吃猫粮");
    }

    public void test(String nam,int age){

    }

}
