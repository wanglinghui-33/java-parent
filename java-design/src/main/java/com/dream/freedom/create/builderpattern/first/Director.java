package com.dream.freedom.create.builderpattern.first;

/**
 * 指挥者
 *
 */
public class Director {

    public Product create(Builder builder){
        builder.buildA();
        builder.buildB();
        builder.buildC();
        builder.buildD();
        return builder.getProduct();
    }
}
