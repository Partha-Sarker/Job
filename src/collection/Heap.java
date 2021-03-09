package collection;

public class Heap {
    private int[] heap;
    public int size = 0;

    public Heap(int capacity) {
        heap = new int[capacity];
    }

    public Heap(int[] heap) {
        size = heap.length;
        this.heap = new int[size];
        for (int i = 0; i < size; i++) {
            this.heap[i] = heap[i];
        }
        for (int i = size/2 - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    public void add(int x) {
        if (isFull())
            return;
        heap[size] = x;
        int currentIndex = size, parent = getParentIndex(currentIndex);
        while (heap[currentIndex] > heap[getParentIndex(currentIndex)]) {
            heap[currentIndex] = heap[parent];
            heap[parent] = x;
            currentIndex = getParentIndex(currentIndex);
        }
        size++;
    }

    public int remove() {
        if (isEmpty())
            return -1;
        int removedValue = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapify(0);
        return removedValue;
    }

    public int getFront() {
        if (isEmpty())
            return -1;
        return heap[0];
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private int getLeftChildrenIndex(int root) {
        return 2 * root + 1;
    }

    private int getRightChildrenIndex(int root) {
        return 2 * root + 2;
    }

    private void heapify(int root) {
        int maxIndex = root;
        int leftChildIndex = getLeftChildrenIndex(root);
        if (leftChildIndex < size && heap[leftChildIndex] > heap[maxIndex])
            maxIndex = leftChildIndex;
        int rightChildIndex = getRightChildrenIndex(root);
        if (rightChildIndex < size && heap[rightChildIndex] > heap[maxIndex])
            maxIndex = rightChildIndex;
        if (maxIndex == root)
            return;
        int temp = heap[maxIndex];
        heap[maxIndex] = heap[root];
        heap[root] = temp;
        heapify(maxIndex);
    }

    public boolean isEmpty() {
        if (size == 0)
            return true;
        return false;
    }

    public boolean isFull() {
        if (size == heap.length)
            return true;
        return false;
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.add(5);
        heap.add(10);
        heap.add(13);
        heap.add(3);
        heap.add(1);
        heap.add(8);
        heap.add(11);
//        heap.printHeap();
        int[] array = {5, 10, 13, 3, 1, 8, 11};
        heap = new Heap(array);
//        heap.printHeap();
        int len = heap.size;
        for (int i = 0; i < len; i++) {
            System.out.print(heap.remove() + " ");
        }
    }
}
