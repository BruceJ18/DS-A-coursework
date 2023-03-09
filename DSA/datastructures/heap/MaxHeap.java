package DSA.datastructures.heap;

public class MaxHeap {

    public static void heapify(int[] array) {
        var lastParentIndex = array.length / 2 - 1;
        for (var i = lastParentIndex; i >= 0; i--)
            heapify(array, i);
    }

    private static void heapify(int[] array, int index) {
        var parentIndex = index;

        var leftChildIndex = index * 2 + 1;
        if (leftChildIndex < array.length && array[leftChildIndex] > array[parentIndex]){
            parentIndex = leftChildIndex;
        }

        var rightChildIndex = index * 2 + 2;
        if (rightChildIndex < array.length && array[rightChildIndex] > array[parentIndex]){
            parentIndex = rightChildIndex;
        }

        if (index == parentIndex) return;

        swap(array, index, parentIndex);
        heapify(array, parentIndex);

    }

    private static void swap(int[] array, int originalParentIndex, int leftOrRightIndex) {
        var temp = array[originalParentIndex];
        array[originalParentIndex] = array[leftOrRightIndex];
        array[leftOrRightIndex] = temp;
    }

//    public static int getKthLargest(int[] array, int k) {
//        if (k < 1 || k > array.length)
//            throw new IllegalArgumentException();
//
//        var heap = new Heap();
//        for (var number : array)
//            heap.insert(number);
//
//        for (var i = 0; i < k - 1; i++)
//            heap.remove();
//
//        return heap.;
//    }
}
