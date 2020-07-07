package com.epam.rd.java.basic.practice2;

import java.util.Iterator;

public class ArrayImpl implements Array {
    private Object[] objArray;

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
            return false;
        }

        @Override
        public Object next() {
            return null;
        }

    }
	
	@Override
    public void add(Object element) {
        add(element);
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
        Object[] anotherObjArray = new Object[objArray.length - 1];
        for (int i = 0, k = 0; i < objArray.length; i++) {
            if (i == index) {
                continue;
            } else {
                anotherObjArray[k++] = objArray[i];
            }
        }
    }

    @Override
    public String toString() {
	    StringBuilder str = new StringBuilder("[");
        for (int i = 0; i < objArray.length; i++) {
            if (i < objArray.length) {
                str.append(objArray[i]);
            } else {
                str.append(objArray[i] + "]");
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }

}
