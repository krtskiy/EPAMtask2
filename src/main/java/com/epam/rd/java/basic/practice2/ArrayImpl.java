package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayImpl implements Array {
    private Object[] array;
    private int nElements = 0;
    private int default_capacity = 10;

    public ArrayImpl(int capacity) {
        this.array = new Object[capacity];
    }

    public ArrayImpl() {
        this.array = new Object[default_capacity];
    }

    @Override
    public void clear() {
        array = new Object[0];
        nElements = 0;
    }

    @Override
    public int size() {
        return nElements;
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {
        int cursor;

        @Override
        public boolean hasNext() {
            return cursor != nElements;
        }

        @Override
        public Object next() {
            if (cursor > nElements) {
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
            nElements--;
        }

    }

    @Override
    public void add(Object element) {
        Object[] temp = new Object[nElements + 1];
        for (int i = 0; i < nElements; i++) {
            temp[i] = array[i];
        }
        temp[temp.length - 1] = element;
        array = temp;
        nElements++;
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
            for (int i = 0; i < nElements; i++) {
                if (array[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < nElements; i++) {
                if (element.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public void remove(int index) {
        Object[] temp = new Object[nElements - 1];
        for (int i = 0, k = 0; i < nElements; i++) {
            if (i == index) {
                continue;
            } else {
                temp[k++] = array[i];
            }
        }
        array = temp;
        nElements--;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        if (nElements != 0) {
            for (int i = 0; i < nElements; i++) {
                if (i < nElements - 1) {
                    str.append(array[i]).append(", ");
                } else {
                    str.append(array[nElements - 1]).append("]");
                }
            }
        } else {
            str.append(" ]");
        }
        return str.toString();
    }

    @SuppressWarnings("all")
    public static void main(String[] args) {
        ArrayImpl arr = new ArrayImpl(5);
        arr.add("A");
        arr.add("B");
        Demo.print(arr);

    }

}
