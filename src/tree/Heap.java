package tree;

import java.util.ArrayList;
import java.util.List;

public class Heap {
    List<Integer> heap;

    Heap(int capacity) {
        heap = new ArrayList<>(capacity);
    }

    Heap() {
        heap = new ArrayList<>();
    }

    public void insert(int value) {
        heap.add(value);
        int size = heap.size();
        if (size == 1)
            return;
        int currentIndex = size - 1, parentIndex = (currentIndex - 1) / 2, parentValue = heap.get(parentIndex);
        while (parentValue < value) {
            heap.set(currentIndex, parentValue);
            heap.set(parentIndex, value);

            currentIndex = parentIndex;

            parentIndex = (parentIndex - 1) / 2;
            parentValue = heap.get(parentIndex);
        }
    }

    public int delete() {
        int size = heap.size();
        if (size == 0)
            return -1;
        int top = heap.get(0), newValue = heap.get(size - 1);
        heap.set(0, newValue);
        heap.remove(size - 1);
        size--;

        int currentIndex = 0, leftIndex = 2 * currentIndex + 1, rightIndex = leftIndex + 1, leftValue, rightValue, maxValue;
        while (leftIndex < size) {
            leftValue = heap.get(leftIndex);
            maxValue = leftValue;
            currentIndex = leftIndex;
            if (rightIndex < size) {
                rightValue = heap.get(rightIndex);
                if (rightValue > maxValue) {
                    maxValue = rightValue;
                    currentIndex = rightIndex;
                }
            }

            if (maxValue > newValue) {
                heap.set((currentIndex - 1) / 2, maxValue);
            }
            else
                break;
            leftIndex = 2 * currentIndex + 1;
            rightIndex = leftIndex + 1;
        }
        return top;
    }

    public int deleteRecursive() {
        int size = heap.size();
        if (size == 0)
            return -1;
        int top = heap.get(0), newValue = heap.get(size - 1);
        heap.set(0, newValue);
        heap.remove(size - 1);
        heapify(0);
        return top;
    }

    private void heapify(int rootIndex) {
        int leftIndex = 2 * rootIndex + 1;
        if (leftIndex >= heap.size())
            return;
        int maxIndex = rootIndex;
        if (heap.get(maxIndex) < heap.get(leftIndex))
            maxIndex = leftIndex;

        int rightIndex = leftIndex + 1;
        if ((rightIndex < heap.size()) && (heap.get(maxIndex) < heap.get(rightIndex)))
            maxIndex = rightIndex;

        if (maxIndex == rootIndex)
            return;

        int temp = heap.get(rootIndex);
        heap.set(rootIndex, heap.get(maxIndex));
        heap.set(maxIndex, temp);

        heapify(maxIndex);
    }

    public void printHeap() {
        for (int value : heap) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(10);
        heap.insert(2);
        heap.insert(15);
        heap.insert(3);
        heap.insert(7);
        heap.insert(5);
        heap.insert(17);
        heap.printHeap();
        heap.deleteRecursive();
        heap.printHeap();
        heap.deleteRecursive();
        heap.printHeap();
        heap.delete();
        heap.printHeap();
        heap.deleteRecursive();
        heap.printHeap();
    }

}
