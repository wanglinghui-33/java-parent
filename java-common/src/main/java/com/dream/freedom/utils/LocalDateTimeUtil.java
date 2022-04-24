package com.dream.freedom.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class LocalDateTimeUtil {

    private static final String DATE_FORMAT_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
    private static final String DATE_FORMAT_DATE = "yyyy-MM-dd";


    /**
     * 将时间字符串转换为时间戳,格式(YYY-MM-DD HH:mm:ss)
     */
    public static long getTimeFromDateStr(String s) {
        return LocalDateTime.parse(s, DateTimeFormatter.ofPattern(DATE_FORMAT_DATE_TIME)).toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }


    /**
     * 获取系统当前时间--格式(yyyy-MM-dd HH:mm:ss)
     *
     * @return 返回当前系统时间
     */
    public static String getNow() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_FORMAT_DATE_TIME));
    }

    /**
     * 把指定LocalDateTime 类型的时间转成字符串
     * @param date 要转成字符串的时间
     * @return 字符串格式
     */
    public static String localDateTimeToStr(LocalDateTime date) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(DATE_FORMAT_DATE_TIME);
        return fmt.format(date);
    }

    /**
     * 获取指定时间的前30天的最小时间
     * @param dateTime 指定时间
     * @return 返回字符串格式的前30天的时间
     */
    public static String getStr(LocalDateTime dateTime) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(DATE_FORMAT_DATE_TIME);
        LocalDateTime localDateTime = LocalDateTime.of(LocalDateTime.now().minus(30, ChronoUnit.DAYS).toLocalDate(), LocalTime.MIN);
        return fmt.format(localDateTime);
    }


}
