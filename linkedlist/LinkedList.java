package datastructures.linkedlist;

import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;

        }
    }


    private Node first;
    private Node last;
    private int size;

    //addLast
    public void addLast(int lastNewValue) {
        var node = new Node(lastNewValue);

        if (isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }
        size++;
    }

    //addFirst
    public void addFirst(int firstNewValue) {
        var node = new Node(firstNewValue);

        if (isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }
        size++;
    }
    private boolean isEmpty() {
        return first == null;
    }

    //deleteFirst
    public void deleteFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last)
            first = last = null;
        else {
            var second = first.next;
            first.next = null;
            first = second;

        }
        size--;
    }

    //deleteLast
    public void deleteLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last)
            first = last = null;
        else {
            var previous = getPrevious(last);
            last = previous;
            last.next = null;

        }
        size--;
    }

    private Node getPrevious(Node node) {
        var current = first;
        while (current != node) {
            if (current.next == last) return current;
            current = current.next;
        }
        return null;
    }

    //contains
    public boolean contains(int item) {
        return indexOf(item) != -1;
    }


    //indexOf
    public int indexOf(int item) {
        int index = 0;
        var current = first;
        while (current != null){
            if (current.value == item) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public int size() {
        return size;
    }

    public int[] toArray() {
        int[] array = new int[size];
        var current = first;
        int index = 0;
        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

    public void reverse() {
        if (isEmpty()) return;

        var previous = first;
        var current = first.next;
        while (current != null){
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        last = first;
        last.next = null;
        first = previous;
    }

    public int getKthFromTheEnd(int k) {
        if (isEmpty()) throw new IllegalStateException();

        var a = first;
        var b = first;
        int initEndDistance = 0;

        while (initEndDistance < k) {
            b = b.next;
            if (b == null)
                throw new IllegalArgumentException();
            initEndDistance++;
        }
        while (b != last) {
            a = a.next;
            b = b.next;
        }
        return a.value;
    }

    public int printMiddle() {
        if (isEmpty()) return -1;
        var end = first;
        int index = 0;
        while (end != last) {
            end = end.next;
            index++;
        }
        return this.getKthFromTheEnd(index/2);
    }
}
