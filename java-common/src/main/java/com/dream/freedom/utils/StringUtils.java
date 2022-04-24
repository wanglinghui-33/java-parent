package com.dream.freedom.utils;

/**
 * 字符串工具类
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {


    /**
     * 是否包含字符串
     *
     * @param str  验证字符串
     * @param strs 字符串组
     * @return 包含返回true
     */
    public static boolean inStringIgnoreCase(String str, String... strs) {
        System.out.println(System.currentTimeMillis());
        if (str != null && strs != null) {
            for (String s : strs) {
                if (s.equalsIgnoreCase(trim(s))) {
                    System.out.println(System.currentTimeMillis());
                    return true;
                }
            }
        }
        System.out.println(System.currentTimeMillis());
        return false;
    }


    /**
     * 把该字符串多个换行符换成一个，最后一个换行符去掉
     *
     * @param str 要操作的字符串
     * @return 处理后的字符串  String str = "4\n\n";
     */
    public static String removeMultipleLine(String str) {
        // 如果没有多个换行符，或者也不是以换行符结尾的，直接返回
        if (!(str.contains("\n\n") || str.endsWith("\n") || str.startsWith("\n"))) {
            return str;
        }
        // 第一个
        char[] chars = str.toCharArray();
        if (10 == chars[0]){
            chars[0] = ' ';
        }
        //最后一个
        if (10 == chars[chars.length - 1] ) {
            chars[chars.length - 1] = ' ';
        }
        for (int i = 1; i < chars.length; i++) {
            if (i < chars.length && 10 == chars[i]) {
                if (chars[i - 1] == chars[i]) {
                    chars[i - 1] = ' ';
                }
            }
        }
        return String.valueOf(chars).replaceAll(" ", "");
    }


}
