package com.dream.freedom.test.time;

import com.dream.freedom.utils.LocalDateTimeUtil;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

public class TimeTest {


    @Test
    public void timeTest(){


        System.out.println(System.currentTimeMillis());
        System.out.println(LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli());


        // 获取当前时间的
        //当天的零点
        System.out.println("当天的零点:  "+LocalDateTime.of(LocalDateTime.now().toLocalDate(), LocalTime.MIN));

        //当天的最后时间
        System.out.println("当天的最后时间:  "+LocalDateTime.of(LocalDateTime.now().toLocalDate(), LocalTime.MAX));

        //System.out.println(LocalDateTime.now().minus(30, ChronoUnit.DAYS));

        System.out.println(LocalDateTime.now().minus(30,ChronoUnit.DAYS).toInstant(ZoneOffset.UTC).toEpochMilli());




    }
}
