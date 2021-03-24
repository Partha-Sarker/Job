package practice;

import java.util.ArrayList;
import java.util.List;

public class Heap {
    List<Integer> heap = new ArrayList<>();

    public void add(int value) {
        int currentIndex = heap.size();
        heap.add(value);
        if (currentIndex == 0)
            return;
        int parentIndex = (currentIndex - 1) / 2;
        int parentValue = heap.get(parentIndex);
        while (parentIndex >= 0 && parentValue < value) {
            heap.set(currentIndex, parentValue);
            heap.set(parentIndex, value);

            currentIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
            parentValue = heap.get(parentIndex);
        }
    }

    public void printHeap() {
        for (int value : heap)
            System.out.print(value + " ");
        System.out.println();
    }

    public Integer remove() {
        int len = heap.size();
        if (len == 0)
            return null;
        int removedValue = heap.get(0);
        if (len == 1) {
            heap.clear();
            return removedValue;
        }
        heap.set(0, heap.get(len - 1));
        heap.remove(len - 1);
        heapify(0);
        return removedValue;
    }

    private void heapify(int rootIndex) {
        int maxIndex = rootIndex, len = heap.size();
        int leftChildIndex = 2 * rootIndex + 1, rightChildIndex = leftChildIndex + 1;
        if (leftChildIndex < len && heap.get(leftChildIndex) > heap.get(maxIndex))
            maxIndex = leftChildIndex;
        if (rightChildIndex < len && heap.get(rightChildIndex) > heap.get(maxIndex))
            maxIndex = rightChildIndex;
        if (maxIndex == rootIndex)
            return;
        int rootValue = heap.get(rootIndex);
        heap.set(rootIndex, heap.get(maxIndex));
        heap.set(maxIndex, rootValue);
        heapify(maxIndex);
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.add(5);
        heap.add(10);
        heap.add(13);
        heap.add(3);
        heap.add(1);
        heap.add(8);
        heap.add(11);
        heap.printHeap();
        heap.remove();
        heap.remove();
        heap.remove();
        heap.printHeap();
    }
}
