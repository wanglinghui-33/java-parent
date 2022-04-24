package com.dream.freedom.create.singleton;

/**
 * 设计模式--单利模式-- 枚举类 实现单利模式
 *
 *      枚举类（线程安全，调用效率高，不能延时加载，可以天然的防止反射和反序列化调用）
 *
 *      枚举类型既然是类，那么就可以有构造方法。只不过只能是私有的(private)，不能有公有的(public)构造方法，这是为了避免直接对枚举类型实例化。
 *
 *
 *      1: enum和class、interface的地位一样
 *
 *      2: 使用enum定义的枚举类默认继承了java.lang.Enum，而不是继承Object类。枚举类可以实现一个或多个接口。
 *
 *      3: 枚举类的所有实例都必须放在第一行展示，不需使用new 关键字，不需显式调用构造器。自动添加public static final修饰。
 *
 *      4: 使用enum定义、非抽象的枚举类默认使用final修饰，不可以被继承。
 *
 *      5: 枚举类的构造器只能是私有的。
 *
 *
 */
public enum SingletonE {

    //枚举元素本身就是单例
    INSTANCE;

    SingletonE(){
        System.out.println("实例化");
    }

    //添加自己需要的操作
    public void print() {
        System.out.println("枚举实现单利");
    }



}
