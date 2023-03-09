package DSA.datastructures.heap;

public class MinHeap {
    private class Node {
        private int key;
        private String value;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node[] nodes = new Node[10];
    private int count;

    public void add(int key,String value) {
        if (isfull()) {
            throw new IllegalStateException();
        }

        nodes[count++] = new Node(key, value);
        bubbleUp();
    }

    public void remove(int key) {
        if (isEmpty())
            throw new IllegalStateException();

        nodes[0] = nodes[--count];

        bubbleDown();
    }


    private void bubbleDown() {
        var index = 0;
        while (index <= count && !isValidParent(index)){
            var smallerChild = smallerChild(index);
            swap(index, smallerChild);
            index = smallerChild;
        }
    }

    public boolean isEmpty() {
        return count == 0;
    }

    private int smallerChild(int index) {
        if (!hasLeftChild(index))
            return index;

        if (!hasRightChild(index))
            return leftChildIndex(index);

        return (leftChild(index).key < rightChild(index).key) ?
                leftChildIndex(index) :
                rightChildIndex(index);
    }

    private void bubbleUp() {
        var index = count - 1;
        while (index > 0 && nodes[index].key < nodes[parent(index)].key) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    private void swap(int first, int second) {
        var temp = nodes[first].key;
        nodes[first].key = nodes[second].key;
        nodes[second].key = temp;
    }

    private int parent(int index) {
        return index / 2 - 1;
    }

    public boolean isempty() {
        return count == 0;
    }

    public boolean isfull() {
        return count == nodes.length;
    }

    private Node rightChild(int index) {
        return nodes[rightChildIndex(index)];
    }

    private Node leftChild(int index) {
        return nodes[leftChildIndex(index)];
    }

    private int leftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int rightChildIndex(int index) {
        return index * 2 + 2;
    }

    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) <= count;
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) <= count;
    }

    private boolean isValidParent(int index) {
        if (!hasLeftChild(index))
            return true;

        var isValid = nodes[index].key <= leftChild(index).key;

        if (hasRightChild(index))
            isValid &= nodes[index].key <= rightChild(index).key;

        return isValid;
    }
}
