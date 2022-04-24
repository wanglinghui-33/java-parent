package com.dream.freedom.utils;

import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IpUtil {


    // -------------ipv4和数值的互转方式一------------------

    /**
     * 将ipv4 地址转换成数字
     *
     * @return 转换成数字类型的ip地址
     */
    public static long ipv4StrToLongOne(String ipv4) {
        String[] ips = ipv4.split("\\.");
        if (ips == null || ips.length != 4) {
            return 0;
        }
        long a = Integer.parseInt(ips[0]);
        long b = Integer.parseInt(ips[1]);
        long c = Integer.parseInt(ips[2]);
        long d = Integer.parseInt(ips[3]);
        long ipNum = a * 256 * 256 * 256 + b * 256 * 256 + c * 256 + d;
        return ipNum;
    }

    /**
     * IP转换为数值--这个方法也是正确的
     *
     * @throws UnknownHostException
     */
    public static long ipv4StrToLongTwo(String ipv4) throws UnknownHostException {
        InetAddress ip = InetAddress.getByName(ipv4);
        byte[] b = ip.getAddress();
        long l = b[0] << 24L & 0xff000000L |
                b[1] << 16L & 0xff0000L |
                b[2] << 8L & 0xff00L |
                b[3] << 0L & 0xffL;
        return l;
    }

    /**
     * 将数字转成ipv4地址
     *
     * @return 转换后的ip地址
     */
    public static String numConvertIp(long ipLong) {
        long mask[] = {0x000000FF, 0x0000FF00, 0x00FF0000, 0xFF000000};
        long num = 0;
        StringBuffer ipInfo = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            num = (ipLong & mask[i]) >> (i * 8);
            if (i > 0)
                ipInfo.insert(0, ".");
            ipInfo.insert(0, Long.toString(num, 10));
        }
        return ipInfo.toString();
    }


    /**
     * 数值转IPV4
     *
     * @param ipLong
     * @return
     */
    public static String numToipv4(long ipLong) {
        String result = "";
        result = (ipLong >>> 24) + "." +
                ((ipLong & 0x00ffffff) >>> 16) + "." +
                ((ipLong & 0x0000ffff) >>> 8) + "." +
                (ipLong & 0x000000ff);
        return result;
    }

    /**
     * @param beginIp 其实IP
     * @param endIp   终止IP
     * @return 获取IPV4段包含哪些IP
     */
    public static List<String> ipv4sList(String beginIp, String endIp) {
        List<String> result = new ArrayList<String>();
        long ip1 = ipv4StrToLongOne(beginIp);
        long ip2 = ipv4StrToLongOne(endIp);
        for (long ip = ip1; ip <= ip2; ip++) {
            result.add(numConvertIp(ip));
        }
        return result;
    }






    // ==============================下面是IPV6的操作===========================================================


    /**
     * ipv6 转BigInteger 数值长达达到35位，而数据库long类型最长可以存储19位，所以
     * ipv6转BigInteger 没有问题，但是BigInteger转long会丢失精度
     * IPv6转成数值类型由于数值过大会导致数据库和我们的Java数据基础类型无法正常存储。
     *
     * 这个是标准ipv6转数字的方法
     *
     *
     */
    public static BigInteger ipv6ToNumber(String ip) {
        String[] ips = ip.split(":");
        BigInteger rs = new BigInteger("0");
        for (int i = 0; i < ips.length; i++) {
            BigInteger a = BigInteger.valueOf(Integer.parseInt(ips[i], 16));
            BigInteger b = BigInteger.valueOf(65536).pow(7 - i);
            BigInteger c = a.multiply(b);
            rs = rs.add(c);
        }
        return rs;
    }


    /**
     * IPV6 格式转 BigInteger
     * 支持
     * 1、16进制
     * 2、0位压缩表示法
     * 3、不支持内嵌IPv4地址
     *
     * @param ipv6 IPV6 地址
     * @return BigInteger
     */
    public static BigInteger ipv6StrToBigInteger(String ipv6) {
        int compressIndex = ipv6.indexOf("::");
        if (compressIndex != -1) {
            String part1s = ipv6.substring(0, compressIndex);
            String part2s = ipv6.substring(compressIndex + 1);
            BigInteger part1 = ipv6StrToBigInteger(part1s);
            BigInteger part2 = ipv6StrToBigInteger(part2s);
            int part1hasDot = 0;
            char ch[] = part1s.toCharArray();
            for (char c : ch) {
                if (c == ':') {
                    part1hasDot++;
                }
            }
            // ipv6 has most 7 dot
            return part1.shiftLeft(16 * (7 - part1hasDot)).add(part2);
        }
        String[] str = ipv6.split(":");
        BigInteger big = BigInteger.ZERO;
        for (int i = 0; i < str.length; i++) {
            //::1
            if (str[i].isEmpty()) {
                str[i] = "0";
            }
            // 说明有内嵌ipv4
            if (str[i].contains(".")) {
                big = big.add(BigInteger.valueOf(ipv4StrToLongOne(str[i])));
            } else {
                big = big.add(BigInteger.valueOf(Long.valueOf(str[i], 16)).shiftLeft(16 * (str.length - i - 1)));
            }
        }
        return big;
    }




    /**
     * BigInteger 转IPV6， 这个是把数字转成 缩写的IPV6 比如：ff01::1101
     *
     * 比如： ff01:0:0:0:0:0:0:1101  会缩写为  ff01::1101
     */
    public static String ipv6BigIntegerToStrOne(BigInteger big) {
        String str = "";
        BigInteger ff = BigInteger.valueOf(0xffff);
        for (int i = 0; i < 8; i++) {
            str = big.and(ff).toString(16) + ":" + str;
            big = big.shiftRight(16);
        }
        //the last :
        str = str.substring(0, str.length() - 1);
        return str.replaceFirst("(^|:)(0+(:|$)){2,8}", "::");
    }

    /**
     *
     * BigInteger 转IPV6 ———— 这个是把数字转成标准的IPV6，比如：ff01:0:0:0:0:0:0:1101
     *
     * 如果  ff01::1101  也会转成 ff01:0:0:0:0:0:0:1101
     */
    public static String ipv6BigIntegerToStrTwo(BigInteger big) {
        String ip = "";
        List<String> ips = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            ips.add(Integer.toHexString(big.divideAndRemainder(BigInteger.valueOf(65536))[1].intValue()));
            big = big.shiftRight(16);
        }
        for (int i = ips.size() - 1; i >= 0; i--) {
            ip = ip.concat(ips.get(i));
            if (i > 0) {
                ip = ip.concat(":");
            }
        }
        return ip;
    }

    /**
     * 查找两个IP地址之间的IP(IPV6)
     * 如果 起始IPV6 比 结束IPV6 大的话，直接返回空集合
     *
     * @param startIp 起始IPV6
     * @param endIp   结束IPV6
     * @return 返回两个IPV6之间的所有IPV6
     */
    public static List<String> ipv6sList(String startIp, String endIp) {
        BigInteger startNumber = ipv6StrToBigInteger(startIp);
        BigInteger endNumber = ipv6StrToBigInteger(endIp).add(BigInteger.valueOf(1));
        List<String> ips = new ArrayList<>();
        while (startNumber.compareTo(endNumber) < 0) {
            ips.add(ipv6BigIntegerToStrTwo(startNumber));
            startNumber = startNumber.add(BigInteger.valueOf(1));
        }
        return ips;
    }

    /**
     * ipv6地址转有符号byte[17]
     */
    private static byte[] ipv6ToBytes(String ipv6) {
        byte[] ret = new byte[17];
        ret[0] = 0;
        int ib = 16;
        boolean comFlag = false;// ipv4混合模式标记
        if (ipv6.startsWith(":"))// 去掉开头的冒号
            ipv6 = ipv6.substring(1);
        String groups[] = ipv6.split(":");
        for (int ig = groups.length - 1; ig > -1; ig--) {// 反向扫描
            if (groups[ig].contains(".")) {
                // 出现ipv4混合模式
                byte[] temp = ipv4ToBytes(groups[ig]);
                ret[ib--] = temp[4];
                ret[ib--] = temp[3];
                ret[ib--] = temp[2];
                ret[ib--] = temp[1];
                comFlag = true;
            } else if ("".equals(groups[ig])) {
                // 出现零长度压缩,计算缺少的组数
                int zlg = 9 - (groups.length + (comFlag ? 1 : 0));
                while (zlg-- > 0) {// 将这些组置0
                    ret[ib--] = 0;
                    ret[ib--] = 0;
                }
            } else {
                int temp = Integer.parseInt(groups[ig], 16);
                ret[ib--] = (byte) temp;
                ret[ib--] = (byte) (temp >> 8);
            }
        }
        return ret;
    }

    /**
     * ipv4地址转有符号byte[5]
     */
    private static byte[] ipv4ToBytes(String ipv4) {
        byte[] ret = new byte[5];
        ret[0] = 0;
        // 先找到IP地址字符串中.的位置
        int position1 = ipv4.indexOf(".");
        int position2 = ipv4.indexOf(".", position1 + 1);
        int position3 = ipv4.indexOf(".", position2 + 1);
        // 将每个.之间的字符串转换成整型
        ret[1] = (byte) Integer.parseInt(ipv4.substring(0, position1));
        ret[2] = (byte) Integer.parseInt(ipv4.substring(position1 + 1,
                position2));
        ret[3] = (byte) Integer.parseInt(ipv4.substring(position2 + 1,
                position3));
        ret[4] = (byte) Integer.parseInt(ipv4.substring(position3 + 1));
        return ret;
    }

    /**
     * 和上面的效率差不多，只是稍微简洁了一下
     * @param ipv4
     * @return
     */
    private static byte[] ipv4ToBytes2(String ipv4) {
        byte[] ret = new byte[5];
        ret[0] = 0;
        String[] array = ipv4.split("\\.");
        for (int i =0;i<array.length;i++){
            ret[i+1] = (byte) Integer.parseInt(array[i]);
        }
        return ret;
    }

    /**
     * 将字符串形式的ip地址转换为BigInteger
     *
     * @param ip 字符串形式的ip地址
     * @return 整数形式的ip地址
     */
    public static BigInteger strToBigInt(String ip) {
        ip = ip.replace(" ", "");
        byte[] bytes;
        if (ip.contains(":")){
            bytes = ipv6ToBytes(ip);
        }else{
            bytes = ipv4ToBytes(ip);
            //bytes = ipv4ToBytes2(ip);
        }
        return new BigInteger(bytes);
    }

    /**
     * 将整数形式的ip地址转换为字符串形式
     *  不能全部成功
     * @param ipInBigInt
     *            整数形式的ip地址
     * @return 字符串形式的ip地址
     */
    /*public static String bigIntToString(BigInteger ipInBigInt) {
        byte[] bytes = ipInBigInt.toByteArray();
        byte[] unsignedBytes = Arrays.copyOfRange(bytes, 1, bytes.length);
        // 去除符号位
        try {
            String ip = InetAddress.getByAddress(unsignedBytes).toString();
            return ip.substring(ip.indexOf('/') + 1).trim();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }*/

    /**
     * 将整数形式的ip地址转换为字符串形式
     *
     * @param ipInBigInt
     *            整数形式的ip地址
     * @return 字符串形式的ip地址
     */
    public static String bigIntToString(BigInteger ipInBigInt) {
        byte[] bytes = ipInBigInt.toByteArray();
        byte[] unsignedBytes = Arrays.copyOfRange(bytes, 1, bytes.length);
        if (bytes.length == 4 || bytes.length == 16) {
            unsignedBytes = bytes;
        }
        // 去除符号位
        try {
            String ip = InetAddress.getByAddress(unsignedBytes).toString();
            return ip.substring(ip.indexOf('/') + 1).trim();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }



}
