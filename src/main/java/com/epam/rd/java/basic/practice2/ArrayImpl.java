package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayImpl implements Array {
    private Object[] array;
    private int size = 0;
    private int defaultCapacity = 10;

    public ArrayImpl(int capacity) {
        this.array = new Object[capacity];
    }

    public ArrayImpl() {
        this.array = new Object[defaultCapacity];
    }

    @Override
    public void clear() {
        array = new Object[0];
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
        int cursor;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public Object next() {
            if (cursor > size) {
                throw new NoSuchElementException();
            }
            if (!hasNext()) {
                return null;
            } else {
                return array[cursor++];
            }
        }

        @Override
        public void remove() {
            ArrayImpl.this.remove(cursor - 1);
            cursor = 0;
            size--;
        }

    }

    @Override
    public void add(Object element) {
        Object[] temp = new Object[size + 1];
        for (int i = 0; i < size; i++) {
            temp[i] = array[i];
        }
        temp[temp.length - 1] = element;
        array = temp;
        size++;
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
        Object[] temp = new Object[size - 1];
        for (int i = 0, k = 0; i < size; i++) {
            if (i == index) {
                continue;
            } else {
                temp[k++] = array[i];
            }
        }
        array = temp;
        size--;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        if (size != 0) {
            for (int i = 0; i < size; i++) {
                if (i < size - 1) {
                    str.append(array[i]).append(", ");
                } else {
                    str.append(array[size - 1]).append("]");
                }
            }
        } else {
            str.append(" ]");
        }
        return str.toString();
    }

    public static void main(String[] args) {


    }

}
