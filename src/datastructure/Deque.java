package datastructure;


public class Deque {
    int[] deque;
    int front = 0, rear = 0, capacity, size;

    Deque (int capacity) {
        this.capacity = capacity;
        deque = new int[capacity];
    }

    public void insertFront(int value) {
        if (isFull()) {
            System.out.println("Capacity full");
            return;
        }
        if (isEmpty()) {
            deque[0] = value;
            front = rear = 0;
        }
        else{
            front = (front + 1) % capacity;
            deque[front] = value;
        }
        size++;
    }

    public void insertRear(int value) {
        if (isFull()) {
            System.out.println("Capacity full");
            return;
        }
        if (isEmpty()) {
            deque[0] = value;
            front = rear = 0;
        }
        else {
            rear--;
            if (rear < 0)
                rear += capacity;
            deque[rear] = value;
        }
        size++;
    }

    public void deleteFront() {
        if (isEmpty()) {
            System.out.println("Empty");
            return;
        }
        front--;
        if (front < 0)
            front += capacity;
        size--;
    }

    public void deleteRear() {
        if (isEmpty()) {
            System.out.println("Empty");
            return;
        }
        rear = (rear + 1) % capacity;
        size--;
    }

    public int getFront() {
        if (isEmpty()) {
            System.out.println("Empty");
            return -1;
        }
        return deque[front];
    }

    public int getRear() {
        if (isEmpty()) {
            System.out.println("Empty");
            return -1;
        }
        return deque[rear];
    }

    public boolean isFull() {
        if (size == capacity)
            return true;
        return false;
    }

    public boolean isEmpty() {
        if (size == 0)
            return true;
        return false;
    }

    public void showValues() {
        for (int i = rear; i < rear + size; i++) {
            int index = i % capacity;
            System.out.print(deque[index] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Deque deque = new Deque(10);
        deque.insertFront(5);
        deque.insertFront(5);
        deque.insertFront(2);
        deque.insertFront(6);
        deque.insertRear(100);
        deque.insertRear(50);
        deque.showValues();
//        Test.printStuffs(deque.getRear(), deque.getFront());
        deque.deleteFront();
        deque.deleteRear();
        deque.showValues();
//        Test.printStuffs(deque.getRear(), deque.getFront());
        deque.deleteRear();
        deque.deleteRear();
        deque.deleteRear();
//        deque.deleteRear();
        deque.deleteFront();
        deque.showValues();

    }

}
