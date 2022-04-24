package com.dream.freedom.thread;

/**
 * 守护线程
 */
public class GuardThreadTest {
    public static void main(String[] args) {

        // 这就是普通的一个线程。
        GuardThread thread = new GuardThread();
        // 在启动线程之前设置
        thread.setDaemon(true);
        // 启动线程
        thread.start();
        thread.setName("守护线程");

        Thread.currentThread().setName("主线程");
        // 这边继续是主线程
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "--->" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

/**
 * 定义一个线程，让其是守护线程
 * 守护线程是一个死循环
 */
class GuardThread extends Thread {
    /**
     * 这个线程是个死循环，会一直执行下去，如果设置这个线程为守护线程时，用户线程结束，守护线程自动结束
     */
    @Override
    public void run() {
        int i = 0;
        while (true) {
            System.out.println(Thread.currentThread().getName() + "---->" + (i++));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

