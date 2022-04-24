package com.dream.freedom.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * 实现Serializable接口
 *
 * 最终结论：
 *  凡是一个类实现了Serializable接口，建议给该类提供一个固定不变的序列化版本号，这样以后该类代码修改了，但是版本号不变，java虚拟机依然认为是同一个类
 */
public class Student implements Serializable {


    // 如果一个类实现了Serializable接口，建议手动将序列化版本号写出来，不建议自动生成，
    // 因为一旦自动生成，代码结构就不能发生变化，如果发生变化，这个序列化版本号将会重新生成，这是java虚拟机就会认为这个一个全新的类
    private static final long serialVersionUID = -6273781998731781033L;

    private Integer id;
    private String no;

    private String name;

    // transient 关键字表示游离，不参与序列化
    private transient Integer age;

    private String desc;

    public Student() {

    }

    public Student(int id, String no, String name, int age) {
        this.id = id;
        this.no = no;
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(no, student.no) &&
                Objects.equals(name, student.name);
    }

    /**
     * 重写了hashCode
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(no, name, age);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(this + "JVM回收");
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
