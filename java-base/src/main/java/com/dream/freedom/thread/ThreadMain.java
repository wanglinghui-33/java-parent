package com.dream.freedom.thread;

/**
 * main方法测试线程
 */
public class ThreadMain {



    public static void main(String[] args) {
        test03();
    }


    public static void test03(){
        // 创建账号信息
        Account account = new Account("10001",10000);

        // 以下四个线程操作的是同一个对象
        Thread t1 = new AccountThread(account);
        Thread t2 = new AccountThread(account);

        Account account2 = new Account("10002",10000);
        Thread t3 = new AccountThread(account2);
        Thread t4 = new AccountThread(account2);

        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");
        t4.setName("t4");


        t1.start();
        t2.start();
        t3.start();
        t4.start();



    }


    /**
     * 这种线程执行， mian begin 输出完成之后，就立即输出main end，
     */
    private static void test01(){
        System.out.println("mian begin");
        Thread thread = new Thread(new MyRunnableJoin());
        thread.setName("join 线程");
        thread.start();
        System.out.println("main end");
    }


    /**
     * 测试join
     */
    private static void test02(){
        System.out.println("mian begin");
        Thread thread = new Thread(new MyRunnableJoin());
        thread.setName("join 线程");
        thread.start();

        try {
            // 这个表示把thread线程合并到当前线程，让主线程形成阻塞，直到thread线程执行完成之后，才能继续往下执行
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main end");
    }



}
