package com.dream.freedom.ip;

import com.dream.freedom.utils.IpUtil;
import sun.net.util.IPAddressUtil;

import java.math.BigInteger;

public class Ipv6Test {



    public static void ipv6Test(){

        //  16进制的ipv6
        String ip1 = "ABCD:EF01:2345:6789:ABCD:EF01:2345:6789";
        String ip2 = "ffff:ffff:ffff:ffff:ffff:ffff:ffff:ffff";
        //  0位压缩表示法
        String ip3 = "FF01::1101";
        String ip4 = "::1";
        String ip5 = "::";
        // 内嵌IPv4地址表示法
        String ip6 = "::0";
        String ip7 = "::192.168.0.1";
        String ip8 = "::FFFF:0.0.0.0";
        String ip9 = "::FFFF";
        String ip10 = "::FFFF:874B:2B34";
        String ip11 = "::FFFF:135.75.43.52";
        String ip12 = "::135.75.43.52";
        String[] array = {ip1,ip2,ip3,ip4,ip5,ip6,ip7,ip8,ip9,ip10,ip11,ip12};
        String ip = "ip";
        // 一下校验格式的方式都是正确的
        /*for (int i = 0; i < array.length; i++) {
            System.out.println("正则校验ipv6格式 ：" + ip + (i+1) + "对应的结果" + ValidatorUtil.isIpv6(array[i]));
        }*/
        for (int i = 0; i < array.length; i++) {
            System.out.println("JDK校验ipv6格式 ：" + ip + (i+1) + "对应的结果" + IPAddressUtil.isIPv6LiteralAddress(array[i]));
        }

        System.out.println("----------------------------------IPV 转数字方法二------------------------------------------");
        long begin2 = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            try {
                System.out.println("ipv6转数字 ：" + ip + (i+1) + "对应的结果" + IpUtil.ipv6StrToBigInteger(array[i]));
            } catch (Exception e) {
                continue;
            }
        }
        long end2 = System.currentTimeMillis();
        System.out.println(end2-begin2);

        System.out.println("----------------------------------IPV 转数字方法三------------------------------------------");
        long begin3 = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            try {
                System.out.println("ipv6转数字 ：" + ip + (i+1) + "对应的结果" + IpUtil.strToBigInt(array[i]));
            } catch (Exception e) {
                continue;
            }
        }
        long end3 = System.currentTimeMillis();
        System.out.println(end3-begin3);

    }

    public static void test() {
        // IPV6 转 BigInteger 没有问题，但是 BigInteger 转long会有问题
        //String ip1 = "abcd:ef01:2345:6789:abcd:ef01:2345:6789";
        //String ip2 = "0:0:0:0:abcd:ef01:2345:6789";
        String ip1 = "abcd:ef01:2345:6789:abcd:ef01:2345:6789";
        String ip2 = "123:ef01:2345:6789:abcd:ef01:2345:6789";

        System.out.println(IpUtil.ipv6StrToBigInteger(ip1) + "===" + IpUtil.ipv6StrToBigInteger(ip1).longValue());
        System.out.println(IpUtil.ipv6StrToBigInteger(ip2) + "===" + IpUtil.ipv6StrToBigInteger(ip2).longValue());

        System.out.println(IpUtil.ipv6BigIntegerToStrOne(new BigInteger("228367255721259569362527394270995113865")));
        System.out.println(IpUtil.ipv6BigIntegerToStrOne(new BigInteger("-6066930334832433271")));

    }

    public static void test2() {

        /*long begin1 = System.currentTimeMillis();
        for (int i=0;i<10000;i++){
            System.out.println(IpUtil.strToBigInt("192.168.60.227"));
        }

        long end1 = System.currentTimeMillis();
        System.out.println(end1 -begin1);*/


        //System.out.println(IpUtil.ipv4StrToLongOne("192.168.60.227"));

        System.out.println(IpUtil.bigIntToString(new BigInteger("3232251107")));
        System.out.println(IpUtil.bigIntToString(new BigInteger("228367255721259569362527394270995113865")));
        System.out.println(IpUtil.bigIntToString(new BigInteger("2269850420")));
        System.out.println(IpUtil.bigIntToString(new BigInteger("1")));
        System.out.println(IpUtil.bigIntToString(new BigInteger("338958331222012082418099330867817091329")));

        int[] nums = {};
        int id = arraySearch(nums, 100);

    }

    private static int arraySearch(int[] nums, int i) {
        return 1;
    }


}
