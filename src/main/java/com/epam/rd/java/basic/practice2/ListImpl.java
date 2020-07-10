package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListImpl implements List {
    private int size = 0;
    Node<Object> first;
    Node<Object> last;

    private static class Node<Objeect> {
        Object item;
        Node<Object> next;
        Node<Object> prev;

        public Node(Node<Object> prev, Object element, Node<Object> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public void clear() {
        
    }

    @Override
    public int size() {
        return size;
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {
        private int nextIndex;
        private Node<Object> lastReturned;
        private Node<Object> next;


        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.item;
        }

    }

    @Override
    public void addFirst(Object element) {
        final Node<Object> f = first;
        final Node<Object> newNode = new Node<>(null, element, f);
        first = newNode;
        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
    }

    @Override
    public void addLast(Object element) {
        final Node<Object> l = last;
        final Node<Object> newNode = new Node<>(l, element, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    @Override
    public void removeFirst() {
        final Node<Object> f = first;
        final Node<Object> next = f.next;
        if (f == null) {
            throw new NoSuchElementException();
        }
        f.item = null;
        f.next = null;
        first = next;
        if (next == null) {
            last = null;
        } else {
            next.prev = null;
        }
        size --;
    }

    @Override
    public void removeLast() {
        final Node<Object> l = last;
        final Node<Object> prev = l.prev;
        if (l == null) {
            throw new NoSuchElementException();
        }
        l.item = null;
        l.prev = null;
        last = prev;
        if (prev == null) {
            first = null;
        } else {
            prev.next = null;
        }
        size--;
    }

    @Override
    public Object getFirst() {
        final Node<Object> f = first;
        if (f == null) {
            throw new NoSuchElementException();
        }
        return f.item;
    }

    @Override
    public Object getLast() {
        final Node<Object> l = last;
        if (l == null) {
            throw new NoSuchElementException();
        }
        return l.item;
    }

    @Override
    public Object search(Object element) {
        return null;
    }

    @Override
    public boolean remove(Object element) {
        return false;
    }

    @Override
    public String toString() {
        return null;
    }

    public static void main(String[] args) {

    }
}
