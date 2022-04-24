package com.dream.freedom.thread;

import com.dream.freedom.common.AlgorithmUtil;

/**
 * 第三种：使用内名内部类创建线程
 */
public class AnonymousInner {

    public static void main(String[] args) {

        // 获取当前线程对象
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());

        long l = System.currentTimeMillis();
        // 创建线程对象，采用匿名内部类的方式
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                long l = System.currentTimeMillis();
                for (int i = 0; i < 100000000; i++) {
                    // System.out.println("分支线程--->" + i);
                    AlgorithmUtil.twoPower(8);
                }
                System.out.println("分支时间：" + (System.currentTimeMillis() - l));
            }
        });
        // 启动线程
        t.start();
        // 这里的代码还是运行在主线程中的
        for (int i = 0; i < 100000000; i++) {
            //System.out.println("主线程--->" + i);
            AlgorithmUtil.twoPower(8);
        }
        System.out.println("主线程时间：" + (System.currentTimeMillis() - l));
    }
}
