package com.dream.freedom.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件输出流测试---从内存把数据写入到硬盘
 * 输出流一定要刷新
 * 字节流是万能流，什么都可以写
 */
public class FileOutputStreamDoc {

    private static final String path = "D:/info.txt";

    /**
     * 文件的复制--一边读取，一遍写入
     */
    public void m3() {
        String path = "D:\\person\\相册\\王辉  陆金兰  婚礼.mp4";
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(path);
            fos = new FileOutputStream("D:/111.mp4");
            byte[] bytes = new byte[1024 * 1024];  // 就是一次1M
            int count = 0;
            int read = 0;
            // 一边读，一边写
            while ((read = fis.read(bytes)) != -1) {
                // 读多少，就写多少，而且一定要用这个，不能直接写，因为最后一个
                fos.write(bytes, 0, read);
                count++;
            }
            System.out.println(count);
            // 输出流，一定要刷新管道
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 这两个异常要分别try，不能放到一起，防止一个报错，另一个无法关不
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 把内存中的数据写入到磁盘中，如果文件不存在，会重新创建
     * 在文件的结尾继续追加内容
     */
    public void m2() {
        FileOutputStream fos = null;
        try {
            // 把内存中的数据写入到磁盘中，如果该文件不存在，则直接创建,在文件的结尾追加内容
            fos = new FileOutputStream(path, true);
            // 一次写入一个
            fos.write(99);
            fos.write(new byte[]{97, 98, 99, 100});

            // 如果把一个字符串写入到文件中，
            String mess = "一个汉字用两个字节，一个英文字母用一个字节，数一下就知道了。";
            fos.write(mess.getBytes());
            // 写入完成之后要刷新
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 把内存中的数据写入到磁盘中，如果文件不存在，会重新创建
     * 写入的时候，会先清空原来的数据，然后再写入，有风险
     */
    public void m1() {
        FileOutputStream fos = null;
        try {
            // 把内存中的数据写入到磁盘中，如果该文件不存在，则直接创建。入的时候，会先清空原来的数据，然后再写入，有风险
            fos = new FileOutputStream(path);
            /*
             * 这种写入方法，每次都是清空后重写写入--这个是一次写一个字符
             */
            fos.write(97);
            // 这次是写入一个byte数组的数据
            fos.write(new byte[]{102, 103, 104});
            // 这个标识写入的数组，从0开始写，写2个，就不写了
            fos.write(new byte[]{106, 107, 108, 109}, 0, 2);
            // 写入完成之后要刷新
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
