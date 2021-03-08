package sorting;

import test.Test;

public class BadSort {
    public static void main(String[] args) {
        int[] unsortedArray = {5, 2, 6, 2, 6, 1, 0, 9};
        int[] sortedArray = insertionSort(unsortedArray);
        printIntArray(sortedArray);
    }

    public static int[] bubbleSort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    public static int[] selectionSort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            int minValue = array[i];
            for (int j = i + 1; j < len; j++) {
                if (array[j] < minValue) {
                    minIndex = j;
                    minValue = array[j];
                }
            }
            int temp = array[i];
            array[i] = minValue;
            array[minIndex] = temp;
        }
        return array;
    }

    public static int[] insertionSort(int[] array) { // 3, 4, 2
        int len = array.length;
        for (int i = 1; i < len; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
        return array;
    }

    public static void printIntArray(int[] array) {
        for (int val : array) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
