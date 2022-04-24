package com.dream.freedom.jdk.java.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

    public static void  mm() throws Exception {
        Date date = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat();
        String format = sdf.format(date);
        System.out.println(format);

        SimpleDateFormat sd = new SimpleDateFormat("yy-MM-dd HH:mm:ss SSS");
        String format1 = sd.format(date);
        System.out.println(format1);

        String dff = "2022-03-27 10:47:39 949";

        SimpleDateFormat dsf = new SimpleDateFormat("yy-MM-dd HH:mm:ss SSS");

        Date parse = dsf.parse(dff);
        System.out.println(parse.toString());

        System.currentTimeMillis();

        long begin = System.currentTimeMillis();
        for (int i=0;i<10000000;i++){

        }
        long end = System.currentTimeMillis();

        System.out.println("执行循环花费时间是："+(end-begin) + "毫秒");
    }
}
