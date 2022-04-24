package com.dream.freedom.inner;

public class ComputerTest {

    public static void comTest(){
        MyMatch mm = new MyMatch();
        // 方法一： 正常使用多态
        Computer c = new ComputerImpl();
        mm.sum(c,100,200);

    }

    public static void comTest2(){
        MyMatch mm = new MyMatch();
        // 方法二： 使用内部类的方式, 就是Computer 这个接口的实现类没有名字
        mm.sum(new Computer() {
            @Override
            public int sum(int x, int y) {
                return x + y;
            }
        },100,200);

    }


}
