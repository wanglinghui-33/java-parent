package com.dream.freedom.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * IO 文件的读取  从文件到内存
 */
public class IoRead {

    /**
     * 获取路径的方式 ，以下两种路径都是可以的--这两种都是绝对路径，如果要读取的文件不在，就会报错FileNotFoundException
     */
    private static final String path = "D:\\document\\test.txt";
    private static final String path1 = "D:/document/test.txt";
    // 这个是相对路径，这样写，表示这个文件在当前项目的当前模块下的根目录下 如果根目录没有，就报错java.io.FileNotFoundException
    private static final String path2 = "info.txt";



    public static void main(String[] args) {
        IoRead ioRead = new IoRead();
        ioRead.readOneByte();
    }

    /**
     * 字节输入流测试，一个读取一个字节
     * 缺点：因为内存和硬盘频繁交互，效率比较低
     */
    private void readOneByte() {
        FileInputStream fis = null;
        try {
            // 获取是获取绝对路径的
            String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
            System.out.println(path);
            // 调用此方法，会有编译异常，所以要try-catch
            fis = new FileInputStream(path + path2);
            // 每次读取一个字节
            int readData = 0;
            // 错误写法： while (readData = fis.read() != -1){}  编译就报错，因为没有括号
            while ((readData = fis.read()) != -1) {
                System.out.println(readData);   // 这个读取返回的是字节码
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 一个读取多个字节
     */
    public void readMultipleByte() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(path);
            System.out.println("返回流当中剩余的字节数量：" + fis.available() + "。跳过多少字节：" + fis.skip(3));

            // 采取byte数组，一次读取多个字节，最多读取数组.length 个字节。如果这个字节的长度是一些值，可能会导致读取的的字节有乱码  这个不适合太大的文件，因为byte[] 数组不能太大
            byte[] bytes = new byte[12];
            // 这个表示读取到的字节数量 （不是字节本身），执行一次，接着往下读取一次，如果结果返回-1 表示没有了
            // int read = fis.read(bytes);

            // 把byte数组转字符串
            // System.out.println(new String(bytes,0, read));
            /*int read1 = fis.read(bytes);     //
            System.out.println(new String(bytes,0, read1));
            int read2 = fis.read(bytes);     //
            System.out.println(new String(bytes,0, read2));*/

            // 一个中文，获取的字节数组长度竟然是3  想不通， 中文是不占用2个字节嘛
            System.out.println("一个中文的byte数组长度：" + "啊".getBytes().length);

            int readCount = 0;
            while ((readCount = fis.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, readCount));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 读取properties文件的方式(IO 和 Properties 联合使用)
     * properties 在java中一般是配置文件，里面都是键值对的方式存放数据
     * 可以灵活的读取配置文件
     * 1、以后经常修改的数据都可以单独写到一个文件中，使用程序动态获取
     * 2、将来只需要修改这个文件即可，java代码不需要修改，不需要重新编译，服务器不需要重启，就可以拿到动态的信息
     */
    private void readProperties() {
        // 读取文件
        FileInputStream inputStream = null;
        try {
            // 如果getResource("") 参数传空字符串，返回的是Target/classes 路径信息
            // Thread.currentThread().getContextClassLoader().getResource("").getPath();
            // 获取当前线程 类加载器
            URL resource = Thread.currentThread().getContextClassLoader().getResource("");
            //inputStream = new FileInputStream("java-base/src/main/resources/io/property.properties");
            inputStream = new FileInputStream(resource.getPath() + "io/property.properties");
            Properties properties = new Properties();
            // 加载
            properties.load(inputStream);
            System.out.println(properties.getProperty("username") + ":" + properties.getProperty("password"));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    // 关闭流
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 直接以流的方式获取文件
     */
    private void readProperties2() {
        // 读取文件
        InputStream inputStream = null;
        try {
            Properties properties = new Properties();
            // 直接以流的方式
            inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("io/property.properties");
            properties.load(inputStream);
            System.out.println(properties.getProperty("username") + ":" + properties.getProperty("password"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    // 关闭流
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 这个是资源绑定器，只能绑定properties类型的文件，并且这个文件必须在类路径下，扩展名不能写
     */
    private void readProperties3(){
        ResourceBundle bundle = ResourceBundle.getBundle("io/property");
        String username = bundle.getString("username");
        System.out.println(username);
    }


}
