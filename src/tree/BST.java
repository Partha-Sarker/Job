package tree;

public class BST {
    Node root;
    int size = 0;

    private static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
        }
    }

    public void insert(int value) {
        size++;
        Node node = new Node(value);
        if (root == null) {
            root = node;
            return;
        }
        Node currentNode = root;
        int currentValue;
        while (true) {
            currentValue = currentNode.value;
            if (value < currentValue) {
                if (currentNode.left != null)
                    currentNode = currentNode.left;
                else {
                    currentNode.left = node;
                    return;
                }
            } else {
                if (currentNode.right != null)
                    currentNode = currentNode.right;
                else {
                    currentNode.right = node;
                    return;
                }
            }
        }
    }

    public void insertRecursive(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }
        insertRecursive(root, value);
    }

    private Node insertRecursive(Node node, int value) {
        if (node == null)
            return new Node(value);
        if (value < node.value)
            node.left = insertRecursive(node.left, value);
        else
            node.right = insertRecursive(node.right, value);
        return node;
    }

    public void printSortedTree() {
        printTree(root);
        System.out.println();
    }

    private void printTree(Node node) {
        if (node == null)
            return;
        printTree(node.left);
        System.out.print(node.value + " ");
        printTree(node.right);
    }

    public boolean hasValue(int value) {
        Node currentNode = root;
        int currentValue;
        while (currentNode != null) {
            currentValue = currentNode.value;
            if (currentValue == value)
                return true;
            if (value < currentValue)
                currentNode = currentNode.left;
            else
                currentNode = currentNode.right;
        }
        return false;
    }

    public void remove(int value) {
        removeRecursive(root, value);
    }

    private Node removeRecursive(Node node, int value) {
        if (node == null)
            return null;

        if (value < node.value)
            node.left = removeRecursive(node.left, value);
        else if (value > node.value)
            node.right = removeRecursive(node.right, value);
        else {
            if (node.left == null)
                return node.right;
            else if (node.right == null)
                return node.left;
            node.value = getMinValue(node.right);
            node.right = removeRecursive(node.right, node.value);
        }

        return node;
    }

    private int getMinValue(Node root) {
        int minValue = root.value;
        while (root.left != null)
        {
            minValue = root.left.value;
            root = root.left;
        }
        return minValue;
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(0);
        tree.insert(5);
        tree.insert(2);
        tree.insert(7);
        tree.insert(-12);
        tree.insert(40);
        tree.insert(3);
        tree.insert(-5);
        tree.insert(1);
        tree.printSortedTree();
        tree.remove(2);
        tree.printSortedTree();
        tree.insertRecursive(-1);
        tree.printSortedTree();
    }
}
