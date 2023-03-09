package DSA.datastructures.queue;


import java.util.ArrayList;

public class LinkedListQueue {
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    private Node head;
    private Node tail;
    private int size;

    public void enqueue(int value) {
        var node = new Node(value);
        if (isEmpty()) {
            head = tail = node;
        }
        else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();

        int value;
        if (head == tail) {
            value = head.value;
            head = tail = null;
        }
        else {
            value = head.value;
            var second = head.next;
            head.next = null;
            head = second;
        }
        size--;
        return value;
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();
        return head.value;
    }

    public int size(){return size;}

    public boolean isEmpty() {return size == 0;}

    public String toString() {
        ArrayList<Integer> list = new ArrayList<>();

        var current = head;
        while (current != null) {
            list.add(current.value);
            current = current.next;
        }
        return list.toString();
    }

}
