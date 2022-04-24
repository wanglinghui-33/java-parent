package com.dream.freedom.create.builderpattern.first;

/**
 * 定义一个抽象类
 * 建造者
 */
public abstract class Builder {

    // 地基
    abstract void buildA();
    // 钢筋水泥
    abstract void buildB();
    // 铺线路
    abstract void buildC();
    // 装修
    abstract void buildD();
    // 获取产品
    abstract Product getProduct();
}
