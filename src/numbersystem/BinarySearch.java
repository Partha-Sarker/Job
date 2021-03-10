package numbersystem;

import test.Test;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {2, 3, 6, 7, 7, 7, 7, 7, 9, 14, 19, 20, 29, 34};
        int value = 15;
        System.out.println(upperBound(array, value) - lowerBound(array, value));
    }

    public static int countOccurrence(int[] array, int value) {
        int lower = lowerBound(array, value);
        int upper = upperBound(array, value);
        return upper - lower;
    }

    public static int binarySearch(int[] array, int value) {
        int start = 0, end = array.length - 1, mid = -1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (array[mid] == value)
                return mid;
            else if (value < array[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    public static int binarySearchRecursive(int[] array, int value) {
        return binSearch(array, value, 0, array.length - 1);
    }

    private static int binSearch(int[] array, int value, int start, int end) {
        if (start > end)
            return -1;
        int mid = (start + end) / 2;
        if (array[mid] == value)
            return mid;
        if (value > array[mid])
            return binSearch(array, value, mid + 1, end);
        else
            return binSearch(array, value, start, mid - 1);

    }

    private static int lowerBound(int[] array, int value) {
        int start = 0, end = array.length - 1, mid = -1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (array[mid] == value && ((mid == 0 || value > array[mid - 1])))
                return mid;
            else if (value > array[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        if (array[mid] < value)
            return mid + 1;
        return mid;
    }

    private static int lowerBoundV2(int[] array, int value) {
        int start = 0, end = array.length - 1, mid;
        while (start < end) {
            mid = (start + end) / 2;
            if (value > array[mid])
                start = mid + 1;
            else
                end = mid;
        }
        return start;
    }

    private static int upperBound(int[] array, int value) {
        int start = 0, end = array.length - 1, mid = -1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (array[mid] == value && (mid == array.length - 1 || array[mid + 1] > value))
                return mid + 1;
            else if (value < array[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        if (array[mid] < value)
            return mid + 1;
        return mid;
    }
}
