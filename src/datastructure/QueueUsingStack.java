package datastructure;

public class QueueUsingStack {
    private StackArray s1, s2;
    int size = 0, capacity;

    public QueueUsingStack(int capacity) {
        s1 = new StackArray(capacity);
        s2 = new StackArray(capacity);
        this.capacity = capacity;
    }

    public void enQueue(int value) {
        if (isFull()) {
            System.out.println("Not enough space");
            return;
        }
        s1.push(value);
        size++;
    }

    public int deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        if (s2.isEmpty()) {
            while (!s1.isEmpty())
                s2.push(s1.pop());
        }
        size--;
//        System.out.println(s2.peek());
        return s2.pop();
    }

    public boolean isEmpty() {
        if (size == 0)
            return true;
        return false;
    }

    public boolean isFull() {
        if (capacity == s1.size + s2.size)
            return true;
        return false;
    }

    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack(10);
        queue.enQueue(5);
        queue.enQueue(6);
        queue.enQueue(2);
        queue.enQueue(8);
        queue.enQueue(-1);
//        queue.printQueue();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
//        queue.printQueue();
        queue.enQueue(5);
        queue.enQueue(6);
        queue.enQueue(2);
        while (!queue.isEmpty())
            System.out.println(queue.deQueue());
//        queue.printQueue();
//        System.out.println(queue.getFront());
//        System.out.println(queue.getRear());
    }
}
