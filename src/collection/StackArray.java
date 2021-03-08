package collection;

public class StackArray {
    int size = 0;
    private int[] stack;

    StackArray(int capacity) {
        stack = new int[capacity];
    }

    public void push(int value) {
        if (size < stack.length) {
            stack[size] = value;
            size++;
        }
        else {
            System.out.println("Not enough space");
        }
    }

    public int pop() {
        if (size > 0) {
            size--;
            return stack[size];
        }
        else {
            System.out.println("Stack is already empty");
            return -1;
        }
    }

    public int peek() {
        if (size > 0) {
            return stack[size - 1];
        }
        else {
            System.out.println("Stack is already empty");
            return -1;
        }
    }

    public int search(int value) {
        for (int i = 0; i < size; i++) {
            if (stack[i] == value)
                return i;
        }
        return -1;
    }

    public boolean isEmpty() {
        if (size == 0)
            return true;
        return false;
    }

    public void printStack() {
        for (int i = 0; i < size; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackArray stack = new StackArray(5);
        stack.push(-3);
        stack.push(5);
        stack.push(7);
        stack.printStack();
        stack.pop();
        System.out.println("Peeking: " + stack.peek());
        stack.pop();
        stack.printStack();
        stack.push(6);
        stack.push(9);
        stack.push(10);
        System.out.println("Searching 9: " + stack.search(9));
        System.out.println("Searching 2: " + stack.search(2));
        stack.printStack();
        stack.pop();
        stack.printStack();
        System.out.println(stack.pop());
    }
}
