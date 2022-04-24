package com.dream.freedom.array;

import java.util.Arrays;
import java.util.Objects;

public class MyStack {

    Object[] objects;

    int index;

    public MyStack(Object[] objects, int index) {
        this.objects = objects;
        this.index = index;
    }

    public MyStack() {
        objects = new Object[10];
    }

    public Object[] getObjects() {
        return objects;
    }

    public void setObjects(Object[] objects) {
        this.objects = objects;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }


    /**
     * 压栈
     */
    public void push(Object object) {

        if (index >= objects.length-1) {
            System.out.println("栈已经满了，不能压栈了");
        }
        index++;
        objects[index] = object;
    }

    /**
     * 弹栈
     */
    public void pop() {
        if (index < 0) {
            System.out.println("栈已经空了");
        }
        index--;
        objects[index] = null;


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyStack myStack = (MyStack) o;
        return index == myStack.index &&
                Arrays.equals(objects, myStack.objects);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(index);
        result = 31 * result + Arrays.hashCode(objects);
        return result;
    }
}

