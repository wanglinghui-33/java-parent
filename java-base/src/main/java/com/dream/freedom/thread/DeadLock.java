package com.dream.freedom.thread;

/**
 * 线程的死锁
 * 两个线程同时共享两个对象 ，出现两个synchronized修饰的时候，容易造成死锁
 * 造成死锁，就会一直僵持，不会出现任何异常，
 */
public class DeadLock {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        Thread thread1 = new MyThread1(o1,o2);
        Thread thread2 = new MyThread2(o1,o2);
        thread1.start();
        thread2.start();
    }
}
class MyThread1 extends Thread{
    Object obj1;
    Object obj2;
    public MyThread1(Object obj1, Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }
    @Override
    public void run() {
        synchronized (obj1){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj2){
                System.out.println(2);
            }
        }
    }
}
class MyThread2 extends Thread{
    Object obj1;
    Object obj2;
    public MyThread2(Object obj1, Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }
    @Override
    public void run() {
        synchronized (obj2){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj1){
                System.out.println(4);
            }
        }
    }
}
