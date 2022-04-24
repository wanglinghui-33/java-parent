package com.dream.freedom.test.base;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 破解密码：长度是6-16位，可能有大小写字母，数字特殊符号
 */
public class BaseTest {


    public String sdf = "~!@#$%^&*()_+[]{};,.<>?-=";

    @Test
    public void test() {
        List<String> stringList = getPasswordNum();
        System.out.println("长度" + stringList.size());
        for (String s : stringList) {
            boolean isFlag = login("admin", s);
            if (isFlag) {
                System.out.println("密码是:" + s);
                break;
            }
        }

    }

    private boolean login(String userName, String password) {
        if ("admin".equals(userName) && "2008338".equals(password)) {
            System.out.println("登录成功");
            return true;
        }
        return false;
    }

    /**
     * 生成4位数密码
     *
     * @return 返回6位数密码
     */
    private List<String> getPasswordNum() {
        char[] str = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        List<String> list = new ArrayList<>();
        for (char aStr : str) {
            for (char aStr1 : str) {
                for (char aStr2 : str) {
                    for (char aStr3 : str) {
                        for (char aStr4 : str) {
                            list.add(String.valueOf(aStr) + aStr1 + aStr2 + aStr3 + aStr4);
                        }
                    }
                }
            }
        }
        return list;
    }

    List<String> strList = new ArrayList<>();


    StringBuilder sd = new StringBuilder();

    private String getPwd(char[] str,int i) {
        for (char c : str) {
            if (i == 0) {
                return String.valueOf(c);
            }
            return c + getPwd(str,--i);
            //System.out.println(info);
        }
        System.out.println("小米");
        return "";
    }

    @Test
    public void test02() {
        char[] str = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        String pwd = getPwd(str, 4);
        System.out.println(pwd);
    }


    @Test
    public void test03() {
        getPassword();
    }


    private void getPassword() {

        // 87个
        char[] str = {
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                '~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '_', '+',
                '[', ']', '{', '}', ';', ',', '.', '<', '>', '?', '-', '='};

        System.out.println(str.length);

        List<String> list = new ArrayList<>();

        for (char c : str) {
            for (char c1 : str) {
                for (char c2 : str) {
                    for (char c3 : str) {
                        list.add(String.valueOf(c) + c1 + c2 + c3);
                    }
                }
            }
        }

        System.out.println(list.size());
    }


}




