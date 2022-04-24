package com.dream.freedom.thread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时器-- 某个时间执行某个任务，或者建个多久执行一次
 * 定时器就是一个线程
 */
public class MyTimer {

    public static void main(String[] args) {

        // 最普通的定时器
        Timer timer = new Timer();
        // 从当前事件开始调用
        //timer.schedule(new MyTimerRun(), new Date());

        // 从当前时间开始执行任务，然后没10秒中再执行一次
        timer.schedule(new MyTimerRun(), new Date(), 1000 * 10);


        // 守护线程
        Timer timer1 = new Timer("守护线程", true);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
        Date parse = new Date();
        try {
            parse = sdf.parse("2022-04-17 15:22:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        timer1.schedule(new MyTimerRun(), parse, 1000 * 17);


        Timer timer2 = new Timer();
        // 使用匿名内部类实现任务调度
        timer2.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("匿名内部类实现任务调度");
            }
        }, new Date(), 1000 * 2);


    }
}

class MyTimerRun extends TimerTask {


    @Override
    public void run() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date());
        System.out.println(format + Thread.currentThread().getName() + "执行了数据备份");
    }
}
