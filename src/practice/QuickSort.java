package practice;

import sorting.BadSort;
import test.Test;

public class QuickSort {
    public static void main(String[] args) {
        int[] unsortedArray = {5, 2, 6, 2, 6, 1, 0, 9};
        sort(unsortedArray);
        BadSort.printIntArray(unsortedArray);
    }

    public static void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int low, int high) {
        if (high > low) {
            int pivotIndex = pivot(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private static int pivot(int[] array, int low, int high) {
        int pivot = array[high], pivotIndex = low - 1;
        for (int i = low; i < high; i++) {
            if (array[i] <= pivot) {
                pivotIndex++;
                int temp = array[pivotIndex];
                array[pivotIndex] = array[i];
                array[i] = temp;
            }
        }
        pivotIndex++;
        int temp = array[pivotIndex];
        array[pivotIndex] = array[high];
        array[high] = temp;
        return pivotIndex;
    }
}
