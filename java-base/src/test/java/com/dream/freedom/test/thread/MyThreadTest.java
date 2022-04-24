package com.dream.freedom.test.thread;

import com.dream.freedom.common.AlgorithmUtil;
import com.dream.freedom.thread.MyRunnable;
import com.dream.freedom.thread.MyThread;
import com.dream.freedom.thread.StopThread;

/**
 * 测试多线程
 * 1、怎么创建线程对象？ -- 直接new 就可以
 * 2、怎么启动线程？    -- 调用线程对象的start() 方法
 * 注意：方法体内的代码永远都是自上而下的顺序依次逐行执行的
 */
public class MyThreadTest {

    public static void main(String[] args) {
        //threadTest01();
        //runnableTest02();
        runnableTest03();

    }

    /**
     * 使用main测试比@Test测试更能看出效果
     * 主线程，分支线程
     * 这个两个线程是并行的
     */
    public static void threadTest01() {
        // 这个方法属于一个主线程，在主栈中运行，相当于main方法
        long l = System.currentTimeMillis();
        // 创建分支线程
        MyThread thread = new MyThread();
        /*
          启动线程
          start() 方法的作用：启动一个分支线程，在JVM中开辟一个新的栈空间，这行代码执行完成之后，瞬间就结束了。
          这段代码的任务只是为了开启一个新的栈空间，只要新的空间开出来，start()方法就结束了，线程就启动成功了。
          启动成功的线程会自动调用run()方法,并且run方法在分支栈的栈底部(压栈)。run方法在分支栈的栈底部，主方法在主栈的栈底部。
          run方法和main方法是平级的
         */
        thread.start();
        try {
            // 这行代码会让线程thread 进入休眠状态嘛？为什么？
            // 不会，因为sleep()方法是静态方法，当执行这行代码的时候，会转成Thread.sleep(2000); 这行代码的作用是：让当前线程进入休眠
            // 也就是main方法进入休眠
            // thread.sleep(2000);
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 终断线程的睡眠---叫醒睡眠的线程 （这种终断睡眠的方式，依靠了java的异常机制）
        thread.interrupt();
        /*
          如果直接调用run方法，就不会启动线程，不会分配新的分支栈，这种方式依然是单线程
         */
        //thread.run();
        // 这里的代码还是运行在主线程中的
        for (int i = 0; i < 100000000; i++) {
            //System.out.println("主线程--->" + i);
            AlgorithmUtil.twoPower(8);
        }
        System.out.println("主线程时间：" + (System.currentTimeMillis() - l));
    }

    /**
     * 测试runnable多线程
     */
    public static void runnableTest02() {
        // 创建一个可运行的对象
        MyRunnable myRunnable = new MyRunnable();
        // 将可运行的对象封装成一个线程对象
        Thread t = new Thread(myRunnable);
        // 给线程起名字
        t.setName("线程A");
        // 启动线程
        t.start();
        // 强制中断线程，该方法已过时，也不建议这样中断，数据容易丢失
        t.stop();

        System.out.println(t.getName());
    }

    /**
     * 使用参数合理中断线程
     */
    private static void runnableTest03() {
        StopThread stopThread = new StopThread();
        // 将可运行的对象封装成一个线程对象
        Thread t = new Thread(stopThread);
        // 给线程起名字
        t.setName("线程B");
        // 启动线程
        t.start();
        // 5秒后中断线程
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 合理中断线程
        stopThread.setIs_flat(false);
    }


}
