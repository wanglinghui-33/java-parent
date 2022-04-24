package com.dream.freedom.io;

import java.io.File;
import java.io.IOException;

public class FileTest {

    /**
     * 获取当前目录下所有的文件
     */
    public void fileTest03() {
        File file = new File("D:\\downloadFile");
        // 获取当前目录下所有的子文件--不能是文件的路径，不然会报错
        File[] files = file.listFiles();
        for (File file1 : files) {
            // 以下输出都是当前目录下对应的文件绝对路径
            System.out.println(file1);
            System.out.println(file1.getAbsolutePath());
        }
    }

    /**
     * 创建目录/文件
     */
    public void fileTest() {
        try {
            File file1 = new File("D:/a/b/c");
            // 判断当前路径或者当前文件是否存在
            if (!file1.exists()) {
                // 这个是以目录的形式创建(这个只能创建一个不存在的目录)-- 如果已经存在，调用此方法返回false
                // 如果是多个不存在的路径，则无法创建，返回false
                boolean mkdir = file1.mkdir();
                System.out.println(mkdir);
            }

            File file2 = new File("D:/e/f/g");
            // 判断当前路径或者当前文件是否存在
            if (!file2.exists()) {
                // 这个是多重目录的创建(这个能创建多个不存在的目录) -- 如果已经存在，调用此方法返回false
                boolean mkdirs = file2.mkdirs();
                System.out.println(mkdirs);
            }

            File file3 = new File("D:/g");
            // 判断当前路径或者当前文件是否存在
            if (!file3.exists()) {
                // 不存在的时候创建--这个是创建文件-- 如果已经存在，调用此方法返回false
                boolean newFile = file3.createNewFile();
                System.out.println(newFile);
            }

            File file4 = new File("info.txt");
            System.out.println("获取绝对路径" + file4.getAbsolutePath());
            
            // 判断是一个目录嘛
            System.out.println(file4.isDirectory());
            // 判断是一个文件嘛
            System.out.println(file4.isFile());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取文件的绝对路径和文件大小(单位字节)
     */
    public void fileTest02() {
        File file5 = new File("pom.xml");
        System.out.println("获取绝对路径" + file5.getAbsolutePath());
        // 获取文件大小，单位字节
        System.out.println("文件大小：" + file5.length());

    }


}
