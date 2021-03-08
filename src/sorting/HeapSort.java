package sorting;

import static sorting.BadSort.printIntArray;

public class HeapSort {
    public static void main(String[] args) {
        int[] array = {5, 2, 6, 2, 6, 1, 0, 9};
        heapSort(array);
        printIntArray(array);
    }

    public static void heapSort(int[] array) {
        buildMaxHeap(array);
    }

    private static void buildMaxHeap(int[] array) {
        int size = array.length;
        for (int i = size/2 - 1; i >= 0; i--) {
            heapify(array, size, i);
        }
        for (int i = size - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int size, int rootIndex) {
        int maxIndex = rootIndex;
        int leftIndex = 2 * maxIndex + 1;
        int rightIndex = leftIndex + 1;

        if (leftIndex < size && array[leftIndex] > array[maxIndex])
            maxIndex = leftIndex;

        if (rightIndex < size && array[rightIndex] > array[maxIndex])
            maxIndex = rightIndex;

        if (maxIndex != rootIndex) {
            int temp = array[maxIndex];
            array[maxIndex] = array[rootIndex];
            array[rootIndex] = temp;
            heapify(array, maxIndex, size);
        }
    }
}
