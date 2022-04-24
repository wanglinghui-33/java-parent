package com.dream.freedom.jdk.java.lang;

public class StringTest {


    /**
     * String 中的compareTo 方法的比较原理--按字典顺序比较两个字符串，举例说明
     * 比如"abced".compareTo("xyz") 结果是-1,说明 前者小于后者，这个比较是把字符串拆分成
     */
    public static void usedMethod() {

        System.out.println("abc".equals("abc"));


        String s1 = "abc";
        System.out.println(s1);     //结果abc

        byte[] bytes = {97, 98, 99};  //定义一个byte的数组
        String s2 = new String(bytes);
        System.out.println(s2);     // 输出abc

        int[] array = {100, 101, 102, 200};
        String s3 = new String(array, 2, 2);
        System.out.println(s3);


        System.out.println("abced".compareTo("xyz"));
        System.out.println("abced".equals("xyz"));

        byte[] bytes1 = "192.168.60.227".getBytes();
        for (int i = 0; i < bytes1.length; i++) {
            System.out.println(bytes1[i]);
        }

        System.out.println("abadefgaa,测试a".replace("a", "G"));
        System.out.println("abadefgaa,测试a".replaceAll("a", "F"));

        System.out.println(100);

        Double num = 12D;
        Double num2 = 12D;
        System.out.println(num == num2);

    }

    public static void StringTest() {
        String a = "abc";
        String b = "abc";
        String c = new String("abc");
        String d = "ab" + "c";
        //这些比较都是错误的，这是拼接之后再判断，肯定都是false

        System.out.println("=======================");
        System.out.println("a == b " + (a == b));//true
        System.out.println("a == c " + (a == c));//false
        System.out.println("a == d " + (a == d));//true
        System.out.println("b == c " + (b == c));//false
        System.out.println("b == d " + (b == d));//true
        System.out.println("c == d " + (c == d));//false
        System.out.println("-----------------");
        System.out.println("abc" == ("ab" + "c"));//true
        System.out.println("-----------------");
        String e = c.intern();//将new出来的字符串对象加入字符串常量池
        System.out.println(a == e);//true
    }

}
