package DSA.datastructures.queue;

public class ArrayQueue {
    private int[] array;
    private int front;
    private int rear;
    private int count;

    public ArrayQueue(int capacity) {
        array = new int[capacity];
    }


    public void enqueue(int item) {
        if (count == array.length)
            throw new IllegalStateException();

        array[rear] = item;
        rear = (rear +1) % array.length;
        count++;


    }

    public int dequeue() {

        var item = array[front];
        array[front] = 0;
        front = (front + 1) % array.length;
        count--;
        return item;

    }

    public int peek() {
        if (count == 0)
            throw new IllegalStateException();
        return array[front];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == array.length;
    }
}
