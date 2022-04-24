package com.dream.freedom.io;

import com.dream.freedom.domain.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 序列化和反序列化
 */
public class SerializeAndDeSerialize {


    /**
     * 序列化
     */
    public void serializeTest(){
        ObjectOutputStream oos = null;
        try {
            // 如果student对象没有实现序列化接口，就会报错，如下：
            // java.io.NotSerializableException: com.dream.freedom.domain.Student
            Student student = new Student(1,"865371526","王玲辉",33);
            // 要写入的文件的地方
            oos = new ObjectOutputStream(new FileOutputStream("students"));
            // 序列化对象
            oos.writeObject(student);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 反序列化
     */
    public void deSerializableTest(){
        ObjectInputStream ois = null;
        try {
            // 要读取的文件
            ois = new ObjectInputStream(new FileInputStream("students"));
            Object object = ois.readObject();
            System.out.println(object);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 序列化集合
     */
    public void serializeTest2(){
        ObjectOutputStream oos = null;
        try {

            // 要写入的文件的地方
            oos = new ObjectOutputStream(new FileOutputStream("studentList"));
            // 序列化对象
            List<Student> list = new ArrayList<>();
            list.add(new Student(2,"865371526","王玲辉",33));
            list.add(new Student(3,"865371526","王学军",33));

            // 这里也可以序列化集合
            //oos.writeObject(list);
            oos.writeObject(Arrays.asList(
                    new Student(2,"865371526","王玲辉",33),
                    new Student(2,"865371526","王玲辉",33))
            );
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 反序列化集合
     */
    public void deSerializableTest2(){
        ObjectInputStream ois = null;
        try {
            // 要读取的文件
            ois = new ObjectInputStream(new FileInputStream("studentList"));
            Object object = ois.readObject();
            if (object instanceof List){
                List<Student> list;
                list = (List<Student>) object;
                for (Student student : list) {
                    System.out.println(student);
                }
            }
            System.out.println(object);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
