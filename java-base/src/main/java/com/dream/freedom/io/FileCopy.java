package com.dream.freedom.io;

import java.io.*;

/**
 * 目录拷贝
 */
public class FileCopy {

    public void fileCopy() {

        // 拷贝源
        File fileSource = new File("D:\\学习");
        // 拷贝目标
        File destSource = new File("D:\\aaa");

        // 执行拷贝操作
        copy(fileSource, destSource);
    }

    /**
     * 开始拷贝
     *
     * @param source 拷贝源
     * @param dest   目标源
     */
    private void copy(File source, File dest) {
        // 如果是文件，就直接拷贝文件
        if (source.isFile()) {
            // 开始一边读取文件，一边拷贝文件
            FileInputStream in = null;
            FileOutputStream ou = null;
            try {
                in = new FileInputStream(source);
                // 需要写入的路径是
                String path2 = dest.getAbsolutePath() + source.getAbsolutePath().substring(2);
                ou = new FileOutputStream(path2);
                // 开始读取文件
                byte[] bytes = new byte[1024 * 1024];
                int readCount = 0;
                while ((readCount = in.read(bytes)) != -1) {
                    // 写入文件
                    ou.write(bytes, 0, readCount);
                }
                // 输出流需要刷新
                ou.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (ou != null) {
                    try {
                        ou.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return;
        }

        // 获取拷贝源下所有信息
        File[] files = source.listFiles();
        if (files != null && files.length > 0) {
            String path1 = dest.getAbsolutePath() + source.getAbsolutePath().substring(2);
            File dir = new File(path1);
            if (!dir.exists() && dir.isDirectory()){
                dir.mkdirs();
            }
            for (File file : files) {
                // 如果是目录的话，就创建目录
                if (file.isDirectory()) {
                    // 组装新的路径
                    String path = dest.getAbsolutePath() + file.getAbsolutePath().substring(2);
                    File newFile = new File(path);
                    if (!newFile.exists()) {
                        // 创建目录
                        newFile.mkdirs();
                    }
                }
                // 递归调用每个目录
                copy(file, dest);
            }
        }
    }


}
