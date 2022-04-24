package com.dream.freedom.reflex;

public class ReflexDO {

    private int id;

    public String name;

    protected int age;

    int sex;

    static {
        System.out.println("静态代码块，类加载的时候执行，并且只执行一次");
    }

    {
        System.out.println("实例代码块，只要创建一次对象就会执行一次，在构造方法之前执行");
    }


    public ReflexDO(){
        System.out.println("无参构造");
    }

    public ReflexDO(int id, String name, int age, int sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        System.out.println("有参构造");
    }
}
