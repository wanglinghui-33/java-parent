package com.dream.freedom.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 实现线程的第三种方式：
 * 实现Callable接口，这个可以获取线程的返回值
 * 缺点：效率比较低
 * 优点：可以获取到线程的返回结果
 */
public class MyThreadFutureTask {

    public static void main(String[] args) {


        FutureTask task = new FutureTask(new MyCallable());
        Thread thread = new Thread(task);
        thread.start();
        System.out.println("main 开始");

        try {
            // 这个方法可以获取线程的返回结果
            Object o = task.get();
            // 后面的程序想要继续执行，必须要等get() 方法执行完成，而get()方法可能需要很久才能执行完成
            // 所以，get()方法这个操作会造成当前线程阻塞
            System.out.println("线程返回的结果是" + o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("main over");
    }
}

class MyCallable implements Callable{

    /**
     * 这个方法相当于线程中的run方法
     * @return
     * @throws Exception
     */
    @Override
    public Object call() throws Exception {
        System.out.println("begin");

        Thread.sleep(1000 * 10);
        System.out.println("end ");

        return 10;
    }
}


