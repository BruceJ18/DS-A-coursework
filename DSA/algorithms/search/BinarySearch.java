package DSA.algorithms.search;

public class BinarySearch {
    public int recursiveSearch(int[] array, int target) {
        return recursiveSearch(array, target, 0, array.length - 1);
    }

    private int recursiveSearch(int[] array, int target, int left, int right) {
        if (right < left)
            return -1;

        var middle = (left + right) / 2;

        if (array[middle] == target)
            return middle;

        if (array[middle] < target)
            return recursiveSearch(array, target, middle + 1, right);

        return recursiveSearch(array, target, left, middle - 1);

    }

    public int iterativeSearch(int[] array, int target) {
        var left = 0;
        var right = array.length - 1;

        while (left <= right) {
            var middle = (left + right) / 2;

            if (array[middle] == target)
                return middle;

            if (array[middle] < target)
                left = middle + 1;
            else
                right = middle - 1;
        }
        return -1;
    }
}
