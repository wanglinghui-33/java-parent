package com.dream.freedom.thread;

import com.dream.freedom.common.AlgorithmUtil;

/**
 * 第二种方式：编写一个类，实现java.lang.Runnable接口  采用接口的方式实现多线程
 * 就目前这个情况来说，这并不是一个线程类，只是一个可运行的类，它还不是一个线程
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        long l = System.currentTimeMillis();
        System.out.println("开始");
        for (int i = 0; i < 100000000; i++) {
            // System.out.println("分支线程--->" + i);
            AlgorithmUtil.twoPower(8);
        }
        System.out.println("分支时间："+(System.currentTimeMillis()-l));
    }
}
