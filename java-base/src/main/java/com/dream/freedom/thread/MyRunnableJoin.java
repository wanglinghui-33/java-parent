package com.dream.freedom.thread;

/**
 * 线程合并 join方法
 */
public class MyRunnableJoin implements Runnable{
    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "---->" + i);

        }

    }
}
