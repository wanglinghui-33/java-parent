package com.dream.freedom.create.builderpattern.first;

public class BuildTest {
    public static void test(){

        Director director = new Director();

        Product product = director.create(new ConcreteBuilder());
        System.out.println(product.toString());

    }

}
