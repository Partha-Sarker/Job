package datastructure;

public class PriorityQueue {
    Heap heap;
    public PriorityQueue(int capacity) {
        heap = new Heap(capacity);
    }

    public void push(int x) {
        heap.add(x);
    }

    public int pop() {
        return heap.remove();
    }

    public int poll() {
        return heap.remove();
    }

    public int peek() {
        return heap.getFront();
    }
}
