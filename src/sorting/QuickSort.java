package sorting;

import static sorting.BadSort.printIntArray;

public class QuickSort {
    public static void main(String[] args) {
        int[] unsortedArray = {5, 2, 6, 2, 6, 1, 0, 9};
        int[] sortedArray = quickSort(unsortedArray);
        printIntArray(sortedArray);
    }

    public static int[] quickSort(int[] array) {
        int len = array.length;
        sort(array, 0, len - 1);
        return array;
    }

    private static void sort(int[] array, int low, int high) {
        if (low < high) {
            int pivot = partition(array, low, high);
            sort(array, low, pivot - 1);
            sort(array, pivot + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int newPivotIndex = low - 1;
        for (int i = low; i < high; i++) {
            if (pivot >= array[i]) {
                newPivotIndex++;
                int temp = array[i];
                array[i] = array[newPivotIndex];
                array[newPivotIndex] = temp;
            }
        }
        newPivotIndex++;
        array[high] = array[newPivotIndex];
        array[newPivotIndex] = pivot;
        return newPivotIndex;
    }
}