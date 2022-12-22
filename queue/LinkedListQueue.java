package datastructures.queue;



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

    public void enqueue(int item) {
        var node = new Node(item);
        if (isEmpty()) {
            head = tail = node;
        }
        else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public int dequeue() {return removeType(true);}

    public int peek() {return head.value;}

    public int size(){return size;}

    public boolean isEmpty() {return size == 0;}

    private int removeType(boolean pop) {
        if (isEmpty())
            throw new IllegalStateException();

        int value;
        if (head == tail){
            value = head.value;
            if (pop)
                head = tail = null;
        }
        else {
            value = head.value;
            var second = head.next;
            if (pop)
                head.next = null;
            head = second;
        }
        if (pop)
            size--;
        return value;
    }
}
