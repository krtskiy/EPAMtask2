package com.epam.rd.java.basic.practice2;

import java.util.Iterator;

public class ArrayImpl implements Array {
    private Object[] array;
    private int size;
    private static final Object[] EMPTY_ARRAY = {};
    private static final Object[] DEFAULT_CAPACITY_EMPTY_ARRAY = {};

    public ArrayImpl(int capacity) {
        if (capacity > 0) {
        this.array = new Object[capacity];
        } else if (capacity == 0) {
            this.array = EMPTY_ARRAY;
        } else {
            throw new IllegalArgumentException("Illegal capacity: " + capacity);
        }
        size = this.array.length;
    }

    public ArrayImpl() {
        this.array = DEFAULT_CAPACITY_EMPTY_ARRAY;
        size = this.array.length;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            return null;
        }

    }

    @Override
    public void add(Object element) {
        Object[] addArray = new Object[size+1];
        for (int i = 0, k = 0; i < size; i++, k++) {
            if (k < size) {
                addArray[k] = array[i];
            }
        }
        addArray[size+1] = element;
    }

    @Override
    public void set(int index, Object element) {
        array[index] = element;
    }

    @Override
    public Object get(int index) {
        return array[index];
    }

    @Override
    public int indexOf(Object element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public void remove(int index) {
        Object[] anotherArray = new Object[array.length - 1];
        for (int i = 0, k = 0; i < size; i++) {
            if (i == index) {
                continue;
            } else {
                anotherArray[k++] = array[i];
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            if (i < array.length) {
                str.append(array[i]);
            } else {
                str.append(array[i] + "]");
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }

}
