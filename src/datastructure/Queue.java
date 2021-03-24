package datastructure;

public class Queue {
    int start = 0, end = 0, size = 0;
    private int[] queue;
    public Queue(int capacity) {
        queue = new int[capacity];
    }

    public void enQueue(int value) {
        if (isFull()) {
            System.out.println("Not enough space");
            return;
        }
        if (isEmpty()) {
            start = end = 0;
            queue[end] = value;
            size++;
            return;
        }
        end = (end + 1) % queue.length;
        queue[end] = value;
        size++;
    }

    public int deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int front = getFront();
        start = (start + 1) % queue.length;
        size--;
        return front;
    }

    public int getFront() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[start];
    }

    public int getRear() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[end];
    }

    public boolean isFull() {
        if (size == queue.length)
            return true;
        return false;
    }

    public boolean isEmpty() {
        if (size == 0)
            return true;
        return false;
    }

    public void printQueue() {
        for (int i = 0; i < size; i++) {
            int index = (i + start) % queue.length;
            System.out.print(queue[index] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue queue = new Queue(10);
        queue.enQueue(5);
        queue.enQueue(6);
        queue.enQueue(2);
        queue.enQueue(8);
        queue.enQueue(-1);
        queue.printQueue();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.printQueue();
        queue.enQueue(5);
        queue.enQueue(6);
        queue.enQueue(2);
        queue.printQueue();
        System.out.println(queue.getFront());
        System.out.println(queue.getRear());
    }
}
