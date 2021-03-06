package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackImpl implements Stack {
    private Object[] arrayStack;
    private int size;
    private int defCap = 10;

    public StackImpl(int size) {
        this.arrayStack = new Object[size];
    }

    public StackImpl() {
        this.arrayStack = new Object[defCap];
    }

    @Override
    public void clear() {
        arrayStack = new Object[0];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {
        int cursor = size - 1;

        @Override
        public boolean hasNext() {
            return cursor >= 0;
        }

        @Override
        public Object next() {
            if (cursor > size) {
                throw new NoSuchElementException();
            }
            if (!hasNext()) {
                return null;
            } else {
                return arrayStack[cursor--];
            }
        }

    }

    @Override
    public void push(Object element) {
        Object[] temp = new Object[size + 1];
        for (int i = 0; i < size; i++) {
            temp[i] = arrayStack[i];
        }
        temp[temp.length - 1] = element;
        arrayStack = temp;
        size++;
    }

    @Override
    public Object pop() {
        Object test = null;
        if (size > 0) {
            test = arrayStack[size - 1];
            Object[] temp = new Object[size - 1];
            for (int i = 1, k = 0; i < size; i++, k++) {
                temp[k] = arrayStack[i];
            }
            arrayStack = temp;
            size--;
        } else {
            return null;
        }
        return test;
    }

    @Override
    public Object top() {
        if (size > 0) {
            return arrayStack[size - 1];
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        if (size != 0) {
            for (int i = 0; i < size; i++) {
                if (i < size - 1) {
                    str.append(arrayStack[i]).append(", ");
                } else {
                    str.append(arrayStack[size - 1]).append("]");
                }
            }
        } else {
            str.append(" ]");
        }
        return str.toString();
    }

    public static void main(String[] args) {
// just my empty main method

    }

}
