package practice;

import sorting.BadSort;

public class MergeSort {
    public static void main(String[] args) {
        int[] unsortedArray = {5, 2, 6, 2, 6, 1, 0, 9};
        sort(unsortedArray);
        BadSort.printIntArray(unsortedArray);
    }

    public static void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);
            merge(array, low, mid, high);
        }
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int len1 = mid - low + 1;
        int len2 = high - mid;
        int[] array1 = new int[len1], array2 = new int[len2];
        for (int i = 0; i < len1; i++)
            array1[i] = array[i + low];

        for (int i = 0; i < len2; i++)
            array2[i] = array[mid + i + 1];

        int currentIndex = low, index1 = 0, index2 = 0;
        while (index1 < len1 && index2 < len2) {
            if (array1[index1] < array2[index2])
                array[currentIndex++] = array1[index1++];
            else
                array[currentIndex++] = array2[index2++];
        }

        if (index1 < len1) {
            while (index1 < len1)
                array[currentIndex++] = array1[index1++];
        }
        else if (index2 < len2)
            while (index2 < len2)
                array[currentIndex++] = array2[index2++];
    }
}
