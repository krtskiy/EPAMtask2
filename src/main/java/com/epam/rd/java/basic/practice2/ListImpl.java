package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListImpl implements List {
    private int size = 0;
    Node<Object> first;
    Node<Object> last;

    private static class Node<Object> {
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
        first = null;
        last = null;
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
        private int nextIndex;
        private Node<Object> next;


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
        size--;
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
                    if (first == x.item) {
                        removeFirst();
                        size--;
                    } else if (last == x.item) {
                        removeLast();
                        size--;
                    } else {
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
                    }
                    return true;
                }
            }
        } else {
            for (Node<Object> x = first; x != null; x = x.next) {
                if (x.item == element) {
                    if (x.item.equals(first)) {
                        removeFirst();
                        size--;
                    } else if (x.item.equals(last)) {
                        removeLast();
                        size--;
                    } else {
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
                    }
                    return true;
                }
            }
        }
        return false;
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