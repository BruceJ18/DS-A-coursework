package datastructures.array;



public class DynammicArray {
    private int[] items;
    private int count;

    public DynammicArray(int length){
        items = new int[length];

    }
    private void resizeIfRequired() {
        if (items.length == count) {
            int[] newItems = new int[count * 2];

            for (int i = 0; i < count; i++)
                newItems[i] = items[i];

            items = newItems;
        }
    }

    public void insert(int item) {
        resizeIfRequired();
        items[count++] = item;
    }

    public void remove(int index) {
        if ( index < 0 || index >= count)
            throw new IllegalArgumentException();

        for (int i = index; i < count; i++)
            items[i] = items[i+1];

        count--;
    }

    public int indexOf(int item) {
        for (int i = 0; i < count; i++){
            if (items[i] == item)
                return i;
        }
        return -1;
    }

    public int max(){
        int maxNum = items[0];

        for (int j : items) {
            if (j > maxNum)
                maxNum = j;
        }

        return maxNum;
    }

    public DynammicArray intersect(DynammicArray otherArray) {
       var intersection = new DynammicArray(count);

       for (int item : items){
           if (otherArray.indexOf(item) >= 0)
               intersection.insert(item);
       }
       return intersection;
    }

    public void reverse() {
        int[] newItems = new int[count];

        for (int i = 0; i < count; i++)
            newItems[i] = items[count - i - 1];

        items = newItems;
    }

    public void insertAt(int item, int index) {
        if ( index < 0 || index >= count)
            throw new IllegalArgumentException();
        resizeIfRequired();
        for (int i = count -1; i >= index; i--)
            items[i+1] = items[i];
        items[index] = item;
        count++;
    }

    public void print() {
        for (int i = 0; i < count; i++)
            System.out.println(items[i]);
    }
}
