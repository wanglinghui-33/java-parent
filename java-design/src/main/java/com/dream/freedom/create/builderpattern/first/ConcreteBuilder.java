package com.dream.freedom.create.builderpattern.first;


/**
 * 具体建造者
 */
public class ConcreteBuilder extends Builder {

    private Product product;

    public ConcreteBuilder() {
        product = new Product();
    }

    @Override
    void buildA() {
        product.setBuildA("地基");
    }


    @Override
    void buildB() {
        product.setBuildB("钢筋水泥");
    }

    @Override
    void buildC() {
        product.setBuildC("铺线路");
    }

    @Override
    void buildD() {
        product.setBuildD("装修");
    }

    @Override
    Product getProduct() {
        return product;
    }
}
