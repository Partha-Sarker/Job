package sorting;

import numbersystem.BinaryDecimal;
import numbersystem.DecimalBinary;
import test.Test;

import static sorting.BadSort.printIntArray;

public class MergeSort {
    public static void main(String[] args) {
        int[] unsortedArray = {5, 2, 6, 2, 6, 1, 0, 9};
        int[] sortedArray = mergeSort(unsortedArray);
        printIntArray(sortedArray);
    }

    public static int[] mergeSort(int[] array) {
        int len = array.length;
        sort(array, 0, len - 1);
        return array;
    }

    private static void sort(int[] array, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            sort(array, low, mid);
            sort(array, mid + 1, high);
            merge(array, low, high, mid);
        }
    }

    private static void merge(int[] array, int low, int high, int mid) {
        int len1 = mid - low + 1;
        int len2 = high - mid;
        int[] arr1 = new int[len1];
        int[] arr2 = new int[len2];
        for (int i = 0; i < len1; i++) {
            arr1[i] = array[i + low];
        }
        for (int i = 0; i < len2; i++) {
            arr2[i] = array[i + mid + 1];
        }
        int currentIndex = low, i = 0, j = 0;
        while (i < len1 && j < len2) {
            if (arr1[i] < arr2[j]) {
                array[currentIndex++] = arr1[i++];
            }
            else
                array[currentIndex++] = arr2[j++];
        }
        if (i < len1){
            while (i < len1) {
                array[currentIndex++] = arr1[i++];
            }
        }
        else if (j < len2) {
            while (j < len2) {
                array[currentIndex++] = arr2[j++];
            }
        }
    }


}
