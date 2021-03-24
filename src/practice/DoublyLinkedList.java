package practice;

public class DoublyLinkedList {
    Node head, tail;

    private static class Node {
        int value;
        Node next, prev;
        Node(int value) {
            this.value = value;
        }
    }

    public void add(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.prev = tail;
        tail = node;
    }

    public void insertAt(int index, int value) {
        Node node = new Node(value);
        if (index == 0) {
            if (head == null)
                add(value);
            else {
                node.next = head;
                head.prev = node;
                head = node;
            }
            return;
        }
        Node currentNode = head;
        for (int i = 1; i < index; i++) {
            currentNode = currentNode.next;
            if (currentNode == null)
                return;
        }
        node.next = currentNode.next;
        node.prev = currentNode;
        currentNode.next = node;
    }

    public void printList() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.value + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public void printReverseList() {
        Node currentNode = tail;
        while (currentNode != null) {
            System.out.print(currentNode.value + " ");
            currentNode = currentNode.prev;
        }
        System.out.println();
    }

    public void enQueue(int value) {
        add(value);
    }

    public Integer deQueue() {
        if (head == null)
            return null;
        int value = head.value;
        if (head == tail)
            head = tail = null;
        else {
            Node next = head.next;
            next.prev = null;
            head = next;
        }
        return value;
    }


    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.enQueue(2);
        list.enQueue(1);
        list.enQueue(5);
        list.printList();
        list.printReverseList();
//        list.insertAt(0, 100);
//        list.insertAt(4, 200);
        list.deQueue();
        list.deQueue();
        list.printList();
    }
}
