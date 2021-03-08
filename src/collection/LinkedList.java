package collection;

class LinkedList<T> {
    Node head;
    int size = 0;

    class Node<T> {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    public void add(T data) {
        Node<T> node = new Node(data);

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

    public void insertAt(int index, T data) {
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

    public void insertAtStart(T data) {
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
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
        System.out.println(currNode.data);
    }

    public void reverseValues() { // a -> b -> c -> d
        Node prev = null, currentNode = head, next = null;

        while (currentNode != null) {
            next = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = next;
        }
        head = prev;
    }
}

class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(5);
        list.showValues();
        list.insertAtStart(-1);
        list.showValues();
        list.insertAtStart(-2);
        list.showValues();
        list.insertAt(1, 100);
        list.insertAt(2, 50);
        list.showValues();
        list.removeAt(0);
        list.showValues();
        list.reverseValues();
        list.showValues();
    }
}
