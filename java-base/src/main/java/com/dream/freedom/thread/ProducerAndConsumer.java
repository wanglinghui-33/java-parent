package com.dream.freedom.thread;

import java.util.List;

/**
 * 生产者和消费者模式
 * 生成一个，消费一个
 * 使用两个线程，
 */
public class ProducerAndConsumer {

    public static void main(String[] args) {

        /*List list = new ArrayList();
        // 两个线程共享一个集合
        Thread t1 = new Thread(new Producer(list));
        Thread t2 = new Thread(new Consumer(list));
        t1.setName("生产者");
        t2.setName("消费者");
        // 启动两个线程
        t1.start();
        t2.start();*/


        Num num = new Num(0);
        Thread t3 = new Thread(new Producer(num));
        Thread t4 = new Thread(new Consumer(num));
        t3.setName("奇数");
        t4.setName("偶数");
        t3.start();
        t4.start();


    }
}

class Num {
    int num;

    public Num(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}


// 生产者
class Producer implements Runnable {
    private List list;
    Num num;

    public Producer(List list) {
        this.list = list;
    }

    public Producer(Num num) {
        this.num = num;
    }

    /**
     * 生成一个，必须要消费掉，，然后才能再允许生成
     */
    @Override
    public void run() {
        while (true) {
            // 生产一个，消费一个
            /*synchronized (list) {
                if (list.size() == 0) {
                    Object obj = new Object();
                    list.add(obj);
                    System.out.println(Thread.currentThread().getName() + "--->" + obj);
                    // 添加成功之后，唤醒消费者
                    list.notify();
                } else {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }*/

            // 输出奇数
            synchronized (num) {
                if (num.getNum() % 2 != 0) {
                    System.out.println(Thread.currentThread().getName() + "--->" + num.getNum());
                    num.setNum(num.getNum() + 1);
                    num.notify();
                } else {
                    try {
                        num.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

// 消费者
class Consumer implements Runnable {
    private List list;
    Num num;

    public Consumer(List list) {
        this.list = list;
    }

    public Consumer(Num num) {
        this.num = num;
    }

    @Override
    public void run() {
        while (true) {
            // 生产一个，消费一个
            /*synchronized (list) {
                if (list.size() > 0) {
                    Object obj = list.remove(0);
                    System.out.println(Thread.currentThread().getName() + "--->" + obj);
                    list.notify();
                } else {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }*/

            // 输出偶数
            synchronized (num) {
                if (num.getNum() % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + "--->" + num.getNum());
                    num.setNum(num.getNum() + 1);
                    num.notify();
                } else {
                    try {
                        num.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }
}
