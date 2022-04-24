package com.dream.freedom.ip;


import com.dream.freedom.utils.IpUtil;

public class Ipv4Test {

    public static void ipv4Test() {

        String ip1 = "0.0.0.0";
        String ip2 = "1.1.1.1";
        String ip3 = "192.168.60.227";
        String ip4 = "222.222.222.222";
        String ip5 = "222.222.222.227";
        String ip6 = "255.255.255.255";
        

        String[] array = {ip1,ip2,ip3,ip4,ip5,ip6};

        String ip = "ip";
        /*
        for (int i = 0; i < array.length; i++) {
            System.out.println("正则校验ipv6格式 ：" + ip + (i+1) + "对应的结果" + ValidatorUtil.isIpv4(array[i]));
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println("JDK校验ipv6格式 ：" + ip + (i+1) + "对应的结果" + IPAddressUtil.isIPv4LiteralAddress(array[i]));
        }*/


        System.out.println("----------------------------------IPV 转数字------------------------------------------");
        long begin = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            try {
                System.out.println("ipv4转数字 ：" + ip + (i+1) + "对应的结果" + IpUtil.ipv4StrToLongOne(array[i]));
            } catch (Exception e) {
                continue;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end-begin);

        System.out.println("----------------------------------方法二------------------------------------------");
        long begin2 = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            try {
                System.out.println("ipv4转数字 ：" + ip + (i+1) + "对应的结果" + IpUtil.ipv4StrToLongTwo(array[i]));
            } catch (Exception e) {
                continue;
            }
        }
        long end2 = System.currentTimeMillis();
        System.out.println(end2-begin2);


        System.out.println("----------------------------------方法三------------------------------------------");
        long begin3 = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            try {
                System.out.println("ipv4转数字 ：" + ip + (i+1) + "对应的结果" + IpUtil.strToBigInt(array[i]));
            } catch (Exception e) {
                continue;
            }
        }
        long end3 = System.currentTimeMillis();
        System.out.println(end3-begin3);




    }
}
