package datastructure;

import java.util.Queue;

public class DoublyLinkedList {
    Node head, tail;
    int size = 0;

    public static class Node {
        int value;
        Node next, prev;
        Node (int value) {
            this.value = value;
        }
    }

    public void add(int value) {
        Node n = new Node(value);
        if (size == 0)
            head = n;
        else {
            n.prev = tail;
            tail.next = n;
        }
        tail = n;
        size++;
    }

    public void addBeginning(int value) {
        Node n = new Node(value);
        if (size == 0)
            tail = n;
        else {
            n.next = head;
            head.prev = n;
        }
        head = n;
        size++;
    }

    public void insertAt(int index, int value) {
        if (index == 0) {
            addBeginning(value);
            return;
        }
        if (index == size) {
            add(value);
            return;
        }
        if (index > size) {
            System.out.println("Invalid index");
            return;
        }
        Node node = new Node(value);
        Node currentNode = head;
        for (int i = 0; i < index - 1; i++) {
            currentNode = currentNode.next;
        }
        Node nextNode = currentNode.next;
        currentNode.next = node;
        node.prev = currentNode;
        node.next = nextNode;
        nextNode.prev = node;
        size++;
    }

    public void remove() {
        if (size <= 0) {
            System.out.println("Invalid index");
            return;
        }
        if (size == 1) {
            head = null;
            tail = null;
        }
        else {
            Node prevNode = tail.prev;
            prevNode.next = null;
            tail = prevNode;
        }
        size--;
    }

    public void removeBeginning() {
        if (size <= 0) {
            System.out.println("Invalid index");
            return;
        }
        if (size == 1) {
            head = null;
            tail = null;
        }
        else {
            Node nextNode = head.next;
            nextNode.prev = null;
            head = nextNode;
        }
        size--;
    }

    public void removeAt(int index) {
        // 2, 3, 6, 4, 9
        if (index < 0 || index >= size) {
            System.out.println("Invalid index");
            return;
        }
        if (index == 0) {
            removeBeginning();
            return;
        }
        if (index == size - 1) {
            remove();
            return;
        }
        Node currentNode = head;
        for (int i = 0; i < index - 1; i++)
            currentNode = currentNode.next;
        Node deleteNode = currentNode.next;
        currentNode.next = deleteNode.next;
        deleteNode.next.prev = currentNode;
        deleteNode.next = null;
        deleteNode.prev = null;
    }

    public void reverse() {
        Node currentNode = head, next, prev = null;
        tail = currentNode;
        while (currentNode != null) {
            next = currentNode.next;
            currentNode.prev = next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = next;
        }
        head = prev;
    }

    public void showValues() {
        Node currentNode = head;
        System.out.print("Original order: ");
        while (currentNode.next != null) {
            System.out.print(currentNode.value + " ");
            currentNode = currentNode.next;
        }
        System.out.println(currentNode.value);
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.addBeginning(4);
        list.insertAt(2, 100);
        list.showValues();
        list.removeBeginning();
        list.remove();
        list.removeAt(1);
        list.add(4);
        list.add(6);
        list.showValues();
        list.reverse();
        list.showValues();
    }
}
