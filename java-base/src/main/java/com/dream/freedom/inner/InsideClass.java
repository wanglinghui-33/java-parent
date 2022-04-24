package com.dream.freedom.inner;


/**
 * 内部类学习
 *
 * 这个是外部类
 */
public class InsideClass {

    /**
     * 这是内部类
     */
    public static class NeiBu {

        /**
         * 缺省的方法---同包下可以访问，或者子类可以访问
         *
         * 访问方式：new InsideClass.NeiBu();
         *
         *
         * 内部类，如果加了 这个和类名一样的方法时，不是同包的外部访问不了
         *
         * 这起始就是一个构造方法
         */
        public NeiBu() {
            System.out.println(2222);
        }

        /**
         * 访问方式 new Orange.Neibu().m();
         */
        public void m() {
            System.out.println(1111111);

        }


    }
}
