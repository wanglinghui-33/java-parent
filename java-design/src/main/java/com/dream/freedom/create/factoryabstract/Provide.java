package com.dream.freedom.create.factoryabstract;

import com.dream.freedom.create.factorymethod.Send;

/**
 *
 * 抽象工厂模式:
 *
 *      工厂模式的缺点：类的创建依赖工厂类，也就是说，如果想要扩展程序，必须对工厂类进行修改，这违背了闭包原则， 所以 就想到了抽象工厂模式
 *
 *      抽象工厂模式，创建多个工厂类，这样一旦需要增加新的功能，直接增加新的工厂类就可以了，不需要修改之前的代码。
 *
 */

/**
 * 接口是全抽象的，实现接口必须要实现接口中的所有方法
 *
 */
public interface Provide {

    Send produce();


}
