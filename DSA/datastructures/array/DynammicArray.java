package DSA.datastructures.array;



public class DynammicArray {
    private int[] array;
    private int count;


    public DynammicArray(int capacity) {
        array = new int[capacity];
    }

    public void insert(int item) {
        resize();
        array[count++] = item;
    }

    public void insertAt(int item, int index) {
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();

        resize();
        for (int i = count - 1; i >= index; i--)
            array[i + 1] = array[i];

        array[index] = item;
        count++;
    }

    public int indexOf(int item) {
        for (int i = 0; i < count; i++) {
            if (array[i] == item)
                return i;
        }
        return -1;
    }

    public void reverse() {
        int[] reverse = new int[count];

        for (int i = 0; i < count; i++)
            array[i] = reverse[count - i - 1];
        array = reverse;
    }

    public void resize() {
        if (array.length == count) {
            int[] newArray = new int[count * 2];

            int index = 0;
            for (int item : array)
                newArray[index++] = item;

            array = newArray;
        }
    }

    public void removeAt(int index) {
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();

        for (int i = index; i < count; i++)
            array[i] = array[i + 1];
        count--;
    }

    public int max() {
        int max = 0;
        for (int i = 0; i < count; i++) {
            if (max < array[i])
                max = array[i];
        }
        return max;
    }

    public void print() {
        for (int i = 0; i < count; i++)
            System.out.println(array[i]);
    }

    public DynammicArray intersect(DynammicArray other) {
        var intersection = new DynammicArray(count);

        for (int item: array) {
            if (other.indexOf(item) >= 0)
                intersection.insert(item);
        }
        return intersection;
    }

    private boolean isEmpty() {
        return count == 0;
    }
}
