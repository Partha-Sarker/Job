package datastructure;

class LinkedList {
    private Node head, sortedHead;
    int size = 0;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public void add(int data) {
        Node node = new Node(data);

        if (head == null)
            head = node;
        else {
            Node currNode = head;
            while (currNode.next != null) {
                currNode = currNode.next;
            }
            currNode.next = node;
        }
        size++;
    }

    public void insertAt(int index, int data) {
        Node node = new Node(data);

        if (index == 0) {
            insertAtStart(data);
            return;
        }
        Node currNode = head; // 0a -> 1b -> 2c -> 3d -> 4e
        for (int i = 0; i < index - 1; i++) {
            currNode = currNode.next;
        }
        node.next = currNode.next;
        currNode.next = node;
        size++;
    }

    public void insertAtStart(int data) {
        Node node = new Node(data);

        node.next = head;
        head = node;
        size++;
    }

    public void removeAt(int index) {
        size--;
        if (index == 0) {
            head = head.next;
            return;
        }
        Node currentNode = head;
        for (int i = 0; i < index - 1; i++) {
            currentNode = currentNode.next;
        }
        currentNode.next = currentNode.next.next;
    }

    public void showValues() {
        Node currNode = head;
        while (currNode.next != null) {
            System.out.print(currNode.value + " ");
            currNode = currNode.next;
        }
        System.out.println(currNode.value);
    }

    public void reverseLinkedList() {
        Node prev = null, currentNode = head, next;

        while (currentNode != null) {
            next = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = next;
        }
        head = prev;
    }

    public void revereLinkedList() {
        reverseRecursively(head, null);
    }

    private void reverseRecursively(Node currentNode, Node prevNode) {
        if (currentNode == null) {
            head = prevNode;
            return;
        }
        Node next = currentNode.next;
        currentNode.next = prevNode;
        reverseRecursively(next, currentNode);
    }

    public void sortLinkedList() {
        sortedHead = null;
        Node currentNode = head, next;
        while (currentNode != null) {
            next = currentNode.next;
            insertionSort(currentNode);
            currentNode = next;
        }
        head = sortedHead;
    }

    public void sortByValue() {
        Node firstNode = head;
        while (firstNode.next != null) {
            Node secondNode = firstNode.next;
            while (secondNode != null) {
                if (firstNode.value > secondNode.value) {
                    int temp = firstNode.value;
                    firstNode.value = secondNode.value;
                    secondNode.value = temp;
                }
                secondNode = secondNode.next;
            }
            firstNode = firstNode.next;
        }
    }

    private void insertionSort(Node node) {
        if (sortedHead == null || sortedHead.value >= node.value) {
            node.next = sortedHead;
            sortedHead = node;
            return;
        }
        Node currentNode = sortedHead;
        while (currentNode.next != null && node.value > currentNode.next.value) {
            currentNode = currentNode.next;
        }
        node.next = currentNode.next;
        currentNode.next = node;
    }

    public static void main(String[] args) {
//        LinkedList list = new LinkedList();
//        list.add(1);
//        list.add(5);
//        list.showValues();
//        list.insertAtStart(-1);
//        list.showValues();
//        list.insertAtStart(-2);
//        list.showValues();
//        list.insertAt(1, 100);
//        list.insertAt(2, 50);
//        list.showValues();
//        list.removeAt(0);
//        list.showValues();
//        list.revereLinkedList();
//        list.showValues();
//        list.sortByValue();
//        list.showValues();
        LinkedList list = new LinkedList();
        list.add(2);
        list.add(1);
        list.add(5);
//        list.remove(1);
//        list.remove(5);
        list.insertAt(0, 100);
        list.insertAt(4, 200);
        list.showValues();
        list.revereLinkedList();
        list.showValues();
        list.sortLinkedList();
        list.showValues();
    }
}
