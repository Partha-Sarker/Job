package collection;

public class QueueUsingStack {
    private StackArray s1, s2;
    int size = 0;

    public QueueUsingStack(int capacity) {
        s1 = new StackArray(capacity);
        s2 = new StackArray(capacity);
    }

    public void enQueue(int value) {
        if (isFull()) {
            System.out.println("Not enough space");
            return;
        }
        s1.push(value);
        size++;
    }

    public int deQueue(int value) {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        if (s2.isEmpty()) {
            while (!s1.isEmpty())
                s2.push(s1.pop());
        }
        size--;
        return s2.pop();
    }

    public boolean isEmpty() {
        if (size == 0)
            return true;
        return false;
    }

    public boolean isFull() {
        if (size == s1.size + s2.size)
            return true;
        return false;
    }
}
