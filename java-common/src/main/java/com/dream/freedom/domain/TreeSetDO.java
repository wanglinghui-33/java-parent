package com.dream.freedom.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TreeSetDO implements Comparable<TreeSetDO> {

    private int age;
    private String name;

    public TreeSetDO(int age, String name) {
        this.age = age;
        this.name = name;
    }


    /**
     * 根据年龄升序
     * @param o 要比较的对象
     * @return 0表示年龄相等，>0 表示当前对象年龄大于要比较的对象，<0 说明当前对象小于要比较的对象
     */
    @Override
    public int compareTo(TreeSetDO o) {
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return "TreeSetDO{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
