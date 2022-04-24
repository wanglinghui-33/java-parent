package com.dream.freedom.test.io;

import com.dream.freedom.io.FileOutputStreamDoc;
import com.dream.freedom.io.FileTest;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class FileIOTest {


    @Test
    public void test05(){
        FileTest fileTest = new FileTest();
        fileTest.fileTest03();
    }

    @Test
    public void test04(){
        FileTest fileTest = new FileTest();
        fileTest.fileTest02();
    }

    @Test
    public void test03(){
        FileTest fileTest = new FileTest();
        fileTest.fileTest();
    }


    @Test
    public void test02() throws FileNotFoundException {
        // 这个是标准输出流，默认是往控制台打印的，
        System.out.println("123");
        System.out.println("abc");

        // 修改打印方式，这个是往文件里打印，日志打印就是这么来的
        System.setOut(new PrintStream("test"));
        System.out.println("wlh日志文件操作");

    }


    @Test
    public void test(){
        FileOutputStreamDoc file = new FileOutputStreamDoc();
        file.m2();
        file.m3();
    }
}
