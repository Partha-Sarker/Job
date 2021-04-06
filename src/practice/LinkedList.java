package practice;

public class LinkedList {
    private Node head, sortedHead;

    private static class Node {
        int value;
        Node next;
        Node (int value) {
            this.value = value;
        }
    }

    public void add(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }
        Node currentNode = head;
        while (currentNode.next != null)
            currentNode = currentNode.next;
        currentNode.next = newNode;
    }

    public void insertAt(int index, int value) {
        Node newNode = new Node(value);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node currentNode = head;
        for (int i = 1; i < index; i++) {
            currentNode = currentNode.next;
            if (currentNode == null)
                return;
        }
        newNode.next = currentNode.next;
        currentNode.next = newNode;
    }

    public void remove(int value) {
        if (head.value == value) {
            head = head.next;
            return;
        }
        Node currentNode = head;
        while (currentNode.next != null) {
            if (currentNode.next.value == value) {
                currentNode.next = currentNode.next.next;
                return;
            }
            currentNode = currentNode.next;
        }

    }

    public void printList() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.value + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public void reverse() {
        Node currentNode = head, prev = null, next;
        while (currentNode != null) {
            next = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = next;
        }
        head = prev;
    }

    public void sort() {
        sortedHead = null;
        Node currentNode = head;
        while (currentNode != null) {
            Node next = currentNode.next;
            insertSorted(currentNode);
            currentNode = next;
        }
        head = sortedHead;
    }

    private void insertSorted(Node node) {
        if (sortedHead == null || node.value < sortedHead.value) {
            node.next = sortedHead;
            sortedHead = node;
            return;
        }
        Node currentNode = sortedHead;
        while (currentNode.next != null && node.value > currentNode.next.value)
            currentNode = currentNode.next;
        node.next = currentNode.next;
        currentNode.next = node;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(2);
        list.add(1);
        list.add(5);
//        list.remove(1);
        list.remove(5);
        list.printList();
        list.insertAt(0, 100);
        list.insertAt(4, 200);
        list.printList();
        list.reverse();
        list.printList();
        list.sort();
        list.printList();
    }
}
