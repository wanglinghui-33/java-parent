package com.dream.freedom.collection;

import java.util.Objects;

public class ListDO {

    private Integer age;

    private String name;

    public ListDO() {
    }

    ListDO(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListDO listDO = (ListDO) o;
        return Objects.equals(age, listDO.age) &&
                Objects.equals(name, listDO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }


}
