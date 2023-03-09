package DSA.datastructures.queue;

public class PriorityQueue {
    private int[] array;
    private int count;

    public PriorityQueue(int capacity) {array = new int[capacity];}

    public void enqueue(int item) {
        if (isFull()) {
            throw new IllegalStateException();
        }
        var i = shiftArray(item);
        array[i] = item;
        count++;
    }

    private int shiftArray(int item) {
        int i;
        for (i = count - 1; i >= 0; i--) {
            if (array[i] > item)
                array[i + 1] = array[i];
            else
                break;
        }
        return i;
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();
        return array[--count];
    }

    public int peek() {
        return array[0];
    }

    public boolean isFull() {
        return count == array.length;
    }

    public boolean isEmpty() {
        return array.length == 0;
    }
}
