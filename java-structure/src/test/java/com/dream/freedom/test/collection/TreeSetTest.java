package com.dream.freedom.test.collection;

import com.dream.freedom.collection.TreeSetTest01;
import org.junit.Test;

public class TreeSetTest {

    @Test
    public void test1(){
        TreeSetTest01 test = new TreeSetTest01();
        test.testInteger();
        test.testString();

        test.testObject();
        test.testObject2();

    }
}
