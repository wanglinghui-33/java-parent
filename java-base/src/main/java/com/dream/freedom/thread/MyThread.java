package com.dream.freedom.thread;

import com.dream.freedom.common.AlgorithmUtil;

/**
 * 实现线程的第一种方式：继承java.lang.Thread类，重写run方法
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        long l = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            // System.out.println("分支线程--->" + i);
            AlgorithmUtil.twoPower(8);
        }
        try {
            // 这个不是中断线程的执行，是终止线程的睡眠
            // 如果分支线程睡眠时间很长的话，需要叫醒睡眠的线程 在主线程成
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("分支时间：" + (System.currentTimeMillis() - l));
    }


}
