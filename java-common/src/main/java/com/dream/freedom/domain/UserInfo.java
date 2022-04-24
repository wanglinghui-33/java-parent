package com.dream.freedom.domain;

import lombok.Data;

@Data
public class UserInfo {

    private int id;

    private String name;

    private int age;

    private int sex;

    private double height;

    private String desc;

    public UserInfo() {

    }

    public UserInfo(String name, int age, int sex) {
        this(1,name,age,sex,178);
    }

    public UserInfo(int id, String name, int age, int sex, double height) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.height = height;

    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", height=" + height +
                ", desc='" + desc + '\'' +
                '}';
    }
}
