package collection;

public class Stack extends DoublyLinkedList{
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(6);
        stack.push(5);
        stack.push(3);
        stack.showValues();
        stack.pop();
        stack.pop();
        stack.showValues();
        System.out.println(stack.peek());
        stack.showValues();
    }

    public void push(int value) {
        add(value);
    }

    public void pop() {
        if (size <= 0) {
            System.out.println("Invalid stack size");
            return;
        }
        remove();
    }

    public int peek() {
        if (size <= 0) {
            System.out.println("Invalid stack size");
            return 0;
        }
        return tail.value;
    }
}
