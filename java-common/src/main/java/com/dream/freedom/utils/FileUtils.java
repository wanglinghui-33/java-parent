package com.dream.freedom.utils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class FileUtils {



    private boolean doCMD() throws Exception {
        String cmd = "mkdir -p /home/wlh";     //创建一个文件夹
        ProcessBuilder processBuilder = new ProcessBuilder("/bin/bash", "-c", cmd);
        Process process = processBuilder.start();
        int code = process.waitFor();
        if (code == 0) {
            return true;
        }
        return false;
    }


    /*protected boolean importAuxiliaryData() {
        PropertiesUtil propertiesUtil = PropertiesUtil.load("config.properties");
        String serverIp = propertiesUtil.getProValue("server.ip");
        ShellUtil.execShell("cd " + dataPath + ";sh ./import_data_auto.sh " + serverIp + " " + targetIp + " " + alarmId + " >/dev/null");
        return true;
    }*/


    /**
     * java 无需解压直接读取zip文件和文件内容-直接读取文件
     *
     * @param targetFile
     * @param map
     * @throws Exception
     */
    public void readZipFile(File targetFile, Map<String, String> map) throws Exception {
        ZipFile zf = new ZipFile(targetFile);
        InputStream in = new BufferedInputStream(new FileInputStream(targetFile));
        ZipInputStream zin = new ZipInputStream(in);
        ZipEntry ze;
        while ((ze = zin.getNextEntry()) != null) {
            if (ze.isDirectory()) {
            } else {
                long size = ze.getSize();
                if (size > 0 && "ngsoc.properties".equals(ze.getName().substring(ze.getName().lastIndexOf("/") + 1))) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(zf.getInputStream(ze), Charset.forName("gbk")));
                    String line;
                    while ((line = br.readLine()) != null && line != "") {
                        System.out.println(line);
                        String[] index = line.split("=");
                        if (index.length == 2) {
                            map.put(index[0], index[1]);
                        }
                    }
                    br.close();
                }
            }
        }
        zin.closeEntry();
    }

    /**
     * 传文件路径解压--先上传再读取
     *
     * @param path
     * @param map
     */
    public void readZipFilePath(String path, Map<String, String> map) throws Exception {
        ZipFile zipFile = new ZipFile(path);
        InputStream in = new BufferedInputStream(new FileInputStream(path));
        ZipInputStream zin = new ZipInputStream(in);
        ZipEntry ze;
        //while每循环一次则读取一个文件
        while ((ze = zin.getNextEntry()) != null) {
            if (ze.isDirectory()) {
            } else {
                long size = ze.getSize();
                if (size > 0) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(zipFile.getInputStream(ze), Charset.forName("UTF-8")));
                    String line;
                    while ((line = br.readLine()) != null && line != "") {
                        String[] index = line.split("=");
                        if (index.length == 2) {
                            map.put(index[0], index[1]);
                        }
                    }
                    br.close();
                }
            }
        }
        zin.closeEntry();
    }

    /**
     * 解析 tar.gz
     *
     * @param tarFile
     * @param map
     * @throws Exception
     */
    /*public static void unTarFile(File tarFile, Map<String, String> map) throws Exception {
        ArchiveInputStream archiveInputStream = null;
        if (StringUtils.endsWithIgnoreCase(tarFile.getName(), ".gz")) {
            archiveInputStream = new ArchiveStreamFactory().createArchiveInputStream("tar", new GZIPInputStream(new BufferedInputStream(new FileInputStream(tarFile))));
        } else {
            archiveInputStream = new ArchiveStreamFactory().createArchiveInputStream("tar", new BufferedInputStream(new FileInputStream(tarFile)));
        }
        TarArchiveEntry entry = null;
        while ((entry = (TarArchiveEntry) archiveInputStream.getNextEntry()) != null) {
            if (entry.getSize() > 0 && "ngsoc.properties".equals(entry.getName().substring(entry.getName().lastIndexOf("/") + 1))) {
                String[] arry = new String(FileUtil.getContent(archiveInputStream)).split("\r\n");
                if (arry != null && arry.length > 0) {
                    for (String str : arry) {
                        if (StringUtils.isNotBlank(str)) {
                            String[] index = str.split("=");
                            if (index.length == 2) {
                                map.put(index[0], index[1]);
                            }
                        }
                    }
                }
            }
        }
    }*/

    /**
     * 解压缩tar
     *
     * @param file
     */
    /*public static void unTarFile(String file, Map<String, String> map) {
        try (FileInputStream fis = new FileInputStream(new File(file));
             GZIPInputStream is = new GZIPInputStream(new BufferedInputStream(fis));
             ArchiveInputStream in = new ArchiveStreamFactory().createArchiveInputStream("tar", is);
             InputStreamReader inr = new InputStreamReader(is, GlobalBaseConstant.UTF_8);//考虑到编码格式
             BufferedReader reader = new BufferedReader(inr)
        ) {
            TarArchiveEntry entry = (TarArchiveEntry) in.getNextEntry();
            String lineTxt = null;
            while (entry != null) {
                String name = entry.getName();
                if (name.endsWith("config.json")) {
                    while ((lineTxt = reader.readLine()) != null) {
                        if (lineTxt.contains("version") || lineTxt.contains("description")) {
                            String[] keys = lineTxt.trim().replaceAll("\"", "").replaceAll(",", "").split(":");
                            if (keys != null && keys.length == 2) {
                                map.put(keys[0], keys[1]);
                            }
                        }
                    }
                    break;
                }
                entry = (TarArchiveEntry) in.getNextEntry();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }*/



    /*==========采用BufferedRe读取文件ader==============*/

    /**
     * 第一种读取文件的方法：一个字符一个字符的读取，并把读取到的数据存放到buffer数组中
     *
     * @param fileName
     * @throws IOException
     */
    public void testBuffered(String fileName) throws IOException {
        Long startTime = System.currentTimeMillis();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        char[] buffer = new char[8 * 1024];
        long count;
        long sum = 0;
        while ((count = reader.read(buffer)) != -1) {
            sum += count;
        }
        reader.close();
        Long endTime = System.currentTimeMillis();
        System.out.println("Total time of BufferedReader is " + (endTime - startTime) + " milliseconds, Total byte is " + sum);
        long time = endTime - startTime;
        System.out.println("用时：" + time);

    }

    private void testRandomAccess(String fileName) throws IOException {
        Long startTime = System.currentTimeMillis();
        RandomAccessFile reader = new RandomAccessFile(fileName, "r");
        int count;
        byte[] buffer = new byte[8 * 1024];//缓冲区
        long sum = 0;
        while ((count = reader.read(buffer)) != -1) {
            sum += count;
        }
        reader.close();
        Long endTime = System.currentTimeMillis();
        System.out.println("Total time of RandomAccess is " + (endTime - startTime) + " milliseconds, Total byte is " + sum);
        long time = endTime - startTime;
        System.out.println("用时：" + time);

    }




}
