package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueImpl implements Queue  {
    private Object[] arrayQueue;
    int size = 0;
    private int defCap = 10;

    public QueueImpl(int cap) {
        this.arrayQueue = new Object[cap];
    }

    public QueueImpl() {
        this.arrayQueue = new Object[defCap];
    }

    @Override
    public void clear() {
        arrayQueue = new Object[0];
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
        int index;

        @Override
        public boolean hasNext() {
            return index != size;
        }

        @Override
        public Object next(){
            if (index > size) {
                throw new NoSuchElementException();
            }
            if (!hasNext()) {
                return null;
            } else {
                return arrayQueue[index++];
            }
        }

    }

    @Override
    public void enqueue(Object element) {
        Object[] temporary = new Object[size + 1];
        for (int i = 0; i < size; i++) {
            temporary[i] = arrayQueue[i];
        }
        temporary[temporary.length - 1] = element;
        arrayQueue = temporary;
        size++;
    }

    @Override
    public Object dequeue(){
        Object test = null;
        if (size > 0) {
        test = arrayQueue[0];
        Object[] temp = new Object[size - 1];
        for (int i = 0, k = 0; i < size; i++, k++) {
            if (i != 0) {
                temp[k] = arrayQueue[i];
            }
        }
        arrayQueue = temp;
        size--;
        } else {
            return null;
        }
        return test;
    }

    @Override
    public Object top() {
        if (size > 0) {
            return arrayQueue[0];
        }
        return null;
    }

    @Override
    public String toString(){
        StringBuilder strBldr = new StringBuilder("[");
        if (size != 0) {
            for (int i = 0; i < size; i++) {
                if (i < size - 1) {
                    strBldr.append(arrayQueue[i]).append(", ");
                } else {
                    strBldr.append(arrayQueue[size - 1]).append("]");
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
