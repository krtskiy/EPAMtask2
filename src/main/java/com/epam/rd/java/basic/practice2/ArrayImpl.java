package com.epam.rd.java.basic.practice2;

import java.util.Iterator;

public class ArrayImpl implements Array {
    private Object[] array;

    public ArrayImpl(int index) {
        this.array = new Object[index];
    }

    @Override
    public void clear() {
        array = new Object[0];
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {
        private int currentIndex;

        @Override
        public boolean hasNext() {
            if (currentIndex > array.length - 1) {
                return false;
            }
            return array[currentIndex] != null;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                return null;
            }
            return array[currentIndex++];
        }

        @Override
        public void remove() {
            ArrayImpl.this.remove(currentIndex - 1);
            currentIndex = 0;
        }
    }

    @Override
    public void add(Object element) {
        Object[] temp = new Object[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }
        temp[temp.length - 1] = element;
        array = temp;
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
        int index = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public void remove(int index) {
        Object[] temp = new Object[array.length - 1];
        int currentArrayIndex = 0;
        int currentTempIndex = 0;

        array[index] = null;

        for (Object o : array) {
            if (o == null) {
                currentArrayIndex++;
                continue;
            }
            temp[currentTempIndex] = array[currentArrayIndex];
            currentArrayIndex++;
            currentTempIndex++;
        }

        array = temp;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        if (array.length != 0) {
            for (Object o : array) {
                result.append(o).append(", ");
            }
            result.deleteCharAt(result.length() - 1).deleteCharAt(result.length() - 1);
        }
        result.append("]");
        return result.toString();
    }

    public static void print(Object string) {
        System.out.println(string);
    }

    public static void main(String[] args) {
        ArrayImpl array = new ArrayImpl(0);

        array.add("A");
        array.add("B");
        array.add("C");
        print(array);

        array.set(1, "D");
        print(array);

        print(array.get(2));

        print(array.indexOf("A"));

        array.remove(1);
        print(array);

        array.clear();
        print(array);

        array.add("A");
        array.add("B");
        array.add("C");
        print(array);

        print(array.size());


        Iterator it = array.iterator();

        print(it.hasNext());
        print(it.next());
        it.remove();
        print(array);

        print(it.hasNext());
        print(it.next());
        it.remove();
        print(array);

        print(it.hasNext());
        print(it.next());
        it.remove();
        print(array);
    }

}
