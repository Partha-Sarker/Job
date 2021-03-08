package collection;

public class Heap {
    private int[] heap;
    public int size = 0;

    public Heap(int capacity) {
        heap = new int[capacity];
    }

    public void add(int x) {

    }

    private void heapify() {

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
}
