package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueImpl implements Queue  {
    private Object[] arr;
    int scale = 0;
    private int defCap = 10;

    public QueueImpl(int cap) {
        this.arr = new Object[cap];
    }

    public QueueImpl() {
        this.arr = new Object[defCap];
    }

    @Override
    public void clear() {
        arr = new Object[0];
        scale = 0;
    }

    @Override
    public int size() {
        return scale;
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {
        int index;

        @Override
        public boolean hasNext() {
            return index != scale;
        }

        @Override
        public Object next(){
            if (index > scale) {
                throw new NoSuchElementException();
            }
            if (!hasNext()) {
                return null;
            } else {
                return arr[index++];
            }
        }

    }

    @Override
    public void enqueue(Object element) {
        Object[] temporary = new Object[scale + 1];
        for (int i = 0; i < scale; i++) {
            temporary[i] = arr[i];
        }
        temporary[temporary.length - 1] = element;
        arr = temporary;
        scale++;
    }

    @Override
    public Object dequeue(){
        Object test = arr[0];
        Object[] temp = new Object[scale - 1];
        for (int i = 0, k = 0; i < scale; i++) {
            if (i == 0) {
                continue;
            } else {
                temp[k++] = arr[i];
            }
        }
        arr = temp;
        scale--;
        return test;
    }

    @Override
    public Object top() {
        return arr[0];
    }

    @Override
    public String toString(){
        StringBuilder strBldr = new StringBuilder("[");
        if (scale != 0) {
            for (int i = 0; i < scale; i++) {
                if (i < scale - 1) {
                    strBldr.append(arr[i]).append(", ");
                } else {
                    strBldr.append(arr[scale - 1]).append("]");
                }
            }
        } else {
            strBldr.append(" ]");
        }
        return strBldr.toString();
    }

    public static void main(String[] args) {
// just my empty method

    }

}
