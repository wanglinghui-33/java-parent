package com.dream.freedom.utils;

import java.util.regex.Pattern;

/**
 * 校验类的共同
 */
public class ValidatorUtil {


    /**
     * IPV4 格式校验的正则表达式
     */
    public static final String REGEX_IPV4 = "((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})(\\.((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})){3}";
    /**
     * IPV6 格式的正则表达式
     */
    public static final String REGEX_IPV6 = "(^((([0-9A-Fa-f]{1,4}:){7}(([0-9A-Fa-f]{1,4}){1}|:))"
            + "|(([0-9A-Fa-f]{1,4}:){6}((:[0-9A-Fa-f]{1,4}){1}|"
            + "((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|"
            + "([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|"
            + "[0-1][0-9][0-9]|([0-9]){1,2})){3})|:))|"
            + "(([0-9A-Fa-f]{1,4}:){5}((:[0-9A-Fa-f]{1,4}){1,2}|"
            + ":((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|"
            + "([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|"
            + "[0-1][0-9][0-9]|([0-9]){1,2})){3})|:))|"
            + "(([0-9A-Fa-f]{1,4}:){4}((:[0-9A-Fa-f]{1,4}){1,3}"
            + "|:((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|"
            + "([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|"
            + "([0-9]){1,2})){3})|:))|(([0-9A-Fa-f]{1,4}:){3}((:[0-9A-Fa-f]{1,4}){1,4}|"
            + ":((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|"
            + "([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|"
            + "[0-1][0-9][0-9]|([0-9]){1,2})){3})|:))|"
            + "(([0-9A-Fa-f]{1,4}:){2}((:[0-9A-Fa-f]{1,4}){1,5}|"
            + ":((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|"
            + "([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|"
            + "[0-1][0-9][0-9]|([0-9]){1,2})){3})|:))"
            + "|(([0-9A-Fa-f]{1,4}:){1}((:[0-9A-Fa-f]{1,4}){1,6}"
            + "|:((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|"
            + "([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|"
            + "[0-1][0-9][0-9]|([0-9]){1,2})){3})|:))|"
            + "(:((:[0-9A-Fa-f]{1,4}){1,7}|(:[fF]{4}){0,1}:((22[0-3]|2[0-1][0-9]|"
            + "[0-1][0-9][0-9]|([0-9]){1,2})"
            + "([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})){3})|:)))$)";
    /**
     * 验证 只能包含英文、数字
     */
    public static final String REGEX_ENGLISH_NUMBER = "^[A-Za-z0-9]+$";
    // 这个校验中英文、数字 不行
    public static String REGEX_ERROR = "^[a-z0-9A-Z\u4e00-\u9f5a] + $";  //这个为啥不行呐？难道是因为小写
    /**
     * 这个是允许 中文、英文、数字 三种类型
     */
    public static String REGEX_CHINESE_ENGLISH_NUMBER = "^[\u4E00-\u9FA5A-Za-z0-9]+$";
    /**
     * 验证端口号 1-65535
     */
    public static String REGEX_PORT = "^(([1-9]\\d{0,3})|([1-5]\\d{4})|(6[0-4]\\d{3})|(65[0-4]\\d{2})|(655[0-2]\\d)|(6553[0-5]))$";
    /**
     * 验证正整数
     */
    public static String REGEX_POSITIVE_INTEGER = "^[1-9]+[0-9]*$";

    /**
     * 校验Mac地址的合法性
     */
    public static String REGEX_MAC = "((([a-fA-F0-9]{2}:){5})|(([a-fA-F0-9]{2}-){5}))[a-fA-F0-9]{2}$";


    // ------------------------以下是方法---------------------------------

    /**
     * 校验IP地址
     */
    public static boolean isIpv4(String ipv4) {
        return Pattern.matches(REGEX_IPV4, ipv4);
    }

    /**
     * 校验IP地址
     */
    public static boolean isIpv6(String ipv6) {
        return Pattern.matches(REGEX_IPV6, ipv6);
    }

    /**
     * 判断输入的字符串是否是 字母、数字和汉字，其他的任何字符都不允许
     *
     * @param str 需要校验的字符串
     * @return 如果满足字母、数子、汉字，返回true，否则返回false
     */
    public static boolean isLetterDigitOrChinese(String str) {
        return str.matches(REGEX_CHINESE_ENGLISH_NUMBER);
    }

    /**
     * 验证端口号 1-65535
     */
    public static boolean checkPort11(String str) {
        return str.matches(REGEX_PORT);
    }

    public static Boolean checkPort(String str) {
        return Pattern.matches(REGEX_PORT, str);
    }

    /**
     * 验证正整数
     */
    public static boolean checkPositiveInteger(String str) {
        return str.matches(REGEX_POSITIVE_INTEGER);
    }

    /**
     * 验证英文、数字
     *
     * @param str 要验证的字符串
     * @return true表示合法，false表示不合法
     */
    public static Boolean isLetterDigit(String str) {
        return Pattern.matches(REGEX_ENGLISH_NUMBER, str);
    }

    /**
     * 校验MAC地址的合法性--只能校验标准的MAC
     * @param mac mac地址
     * @return true表示是合法的MAC地址，false表示不合法
     */
    public static Boolean checkMac(String mac){
        return mac.matches(REGEX_MAC);
    }


}
