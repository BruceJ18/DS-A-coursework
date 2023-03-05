package datastructures.heap;

public class Heap {
    private int count;
    private int capacity = 10;
    private int[] array = new int[capacity];

    public void insert(int value) {
        if (isFull()) throw new IllegalStateException();

        array[count++] = value;

        bubbleUp();
    }

    public void remove() {
        if (isEmpty()) throw new IllegalStateException();

        array[0] = array[count];

        bubbleDown();
    }

    private void bubbleDown() {


        var index = 0;
        while (index <= count && !isRootGreatest(index)) {
            var largerChildIndex = largerChildIndex(index);
            swap(index, largerChildIndex);
            index = largerChildIndex;
        }
    }

    private int largerChildIndex(int root) {
        if (!hasLeftChild(root)) return root;
        if (!hasRightChild(root)) return leftChildIndex(root);

        return (leftChild(root) > rightChild(root) ? leftChildIndex(root) : rightChildIndex(root));
    }

    private int leftChild(int root) {return array[leftChildIndex(root)];}

    private int rightChild(int root) {return array[rightChildIndex(root)];}

    private int leftChildIndex(int root) {return root * 2 + 1;}

    private int rightChildIndex(int root) {return root * 2 + 2;}

    private boolean hasLeftChild(int root) {return leftChildIndex(root) <= count;}

    private boolean hasRightChild(int root) {return rightChildIndex(root) <= count;}

    private boolean isRootGreatest(int root) {
        if (!hasLeftChild(root)) return true;

        var isRootGreatest = array[root] >= array[rightChildIndex(root)];

        if (hasRightChild(root))
            return isRootGreatest &= array[root] >= array[leftChildIndex(root)];

        return isRootGreatest;
    }

    private boolean isFull() {
        return array.length == count;
    }

    private void bubbleUp() {
        var index = count - 1;
        while (index > 0 && array[index] > array[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    private void swap(int child, int parent) {
        var temp = array[child];
        array[child] = array[parent];
        array[parent] = temp;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private boolean isEmpty() {
        return count == 0;
    }

    public static boolean isMaxHeap(int[] array) {return isMaxHeap(array, 0);}

    private static boolean isMaxHeap(int[] array, int root) {
        var parentIndex = (array.length - 2) / 2;
        if (root > parentIndex) return true;

        var leftChild = parentIndex * 2 + 1;
        var rightChild = parentIndex * 2 + 2;

        var isRootGreatest = array[root] >= array[leftChild]
                && array[root] >= array[rightChild];

        return isRootGreatest && isMaxHeap(array, leftChild) && isMaxHeap(array, rightChild);

    }

}

