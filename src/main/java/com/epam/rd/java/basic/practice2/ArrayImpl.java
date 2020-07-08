package com.epam.rd.java.basic.practice2;

import java.util.Iterator;

public class ArrayImpl implements Array {
    int arrCapacity;
    private Object[] objArray = new Object[arrCapacity];
    int ind;

    public ArrayImpl(int arrCapacity) {
        this.objArray = objArray;
        this.arrCapacity = arrCapacity;
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {

        @Override
        public boolean hasNext() {
            if (ind < objArray.length) {
                return true;
            } else {
            return false;
            }
        }

        @Override
        public Object next() {
            if (hasNext()) {
            return objArray[ind++];
            } else {
                return null;
            }
        }

    }

    @Override
    public void add(Object element) {
        Object[] temp = objArray;
        objArray = new Object[temp.length + 1];
        objArray = temp.clone();
        objArray[objArray.length - 1] = element;
//        Object[] addObjArray = new Object[objArray.length+1];
//        for (int i = 0, k = 0; i < objArray.length+1; i++) {
//            if (k < objArray.length+1) {
//                addObjArray[k++] = objArray[i];
//            } else {
//                addObjArray[k] = element;
//            }
//        }
    }

    @Override
    public void set(int index, Object element) {
        objArray[index] = element;
    }

    @Override
    public Object get(int index) {
        return objArray[index];
    }

    @Override
    public int indexOf(Object element) {

        return 0;
    }

    @Override
    public void remove(int index) {
        Object[] removeObjArray = new Object[objArray.length - 1];
        for (int i = 0, k = 0; i < objArray.length; i++) {
            if (i == index) {
                continue;
            } else {
                removeObjArray[k++] = objArray[i];
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        for (int i = 0; i < objArray.length; i++) {
            if (i < objArray.length) {
                str.append(objArray[i] + ", ");
            } else {
                str.append(objArray[i] + "]");
            }
        }
        return null;
    }

    public static void main(String[] args) {
        
    }

}
