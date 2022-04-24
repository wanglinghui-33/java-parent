package com.dream.freedom.utils;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatterBuilder;

public class DateUtil {


    public static final String DATE_FORMAT_SHORT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 校验时间字符串是否合法
     *
     * @param dateStr the date str
     * @param pattern the pattern
     * @return the boolean
     */
    public static boolean validDateStr(String dateStr, String pattern) {
        if (StringUtils.isEmpty(pattern)) {
            pattern = DATE_FORMAT_SHORT;
        }
        try {
            LocalDate.parse(dateStr, new DateTimeFormatterBuilder().appendPattern(pattern).parseStrict().toFormatter());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
