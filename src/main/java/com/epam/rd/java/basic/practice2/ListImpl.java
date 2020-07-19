package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListImpl implements List {
    private int size = 0;
    Node<Object> first;
    Node<Object> last;

    private static class Node<O> {
        O item;
        Node<O> next;
        Node<O> prev;

        public Node(Node<O> prev, O element, Node<O> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public void clear() {
        for (Node<Object> x = first; x != null; ) {
            Node<Object> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
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
        private int nextIndex = 0;
        private Node<Object> next = first;


        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public Object next() {
            Node<Object> lastReturned;
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
        f.item = null;
        f.next = null;
        first = next;
        if (next == null) {
            last = null;
        } else {
            next.prev = null;
        }
        size--;
    }

    @Override
    public void removeLast() {
        final Node<Object> l = last;
        final Node<Object> prev = l.prev;
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
            return null;
        }
        return f.item;
    }

    @Override
    public Object getLast() {
        final Node<Object> l = last;
        if (l == null) {
            return null;
        }
        return l.item;
    }

    @Override
    public Object search(Object element) {
        if (element == null) {
            for (Node<Object> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    return null;
                }
            }
        } else {
            for (Node<Object> x = first; x != null; x = x.next) {
                if (element.equals(x.item)) {
                    return element;
                }
            }
        }
        return null;
    }


    @Override
    public boolean remove(Object element) {
        if (element == null) {
            for (Node<Object> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    return remover((Node<Object>) x);
                }
            }
        } else {
            for (Node<Object> x = first; x != null; x = x.next) {
                if (x.item == element) {
                    return remover((Node<Object>) x);
                }
            }
        }
        return false;
    }

    private boolean remover(Node<Object> x) {
        final Node<Object> next = x.next;
        final Node<Object> prev = x.prev;
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        if (size != 0) {
            for (Node<Object> x = first; x != null; x = x.next) {
                if (x != last) {
                    str.append(x.item).append(", ");
                } else {
                    str.append(x.item).append("]");
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