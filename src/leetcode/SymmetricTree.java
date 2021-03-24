package leetcode;

public class SymmetricTree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        TreeNode headL = new TreeNode(2);
        TreeNode headR = new TreeNode(2);
        TreeNode headLL = new TreeNode(3);
        TreeNode headLR = new TreeNode(4);
        TreeNode headRL = new TreeNode(4);
        TreeNode headRR = new TreeNode(3);
        head.left = headL;
        head.right = headR;
        headL.left = headLL;
        headL.right = headLR;
        headR.left = headRL;
        headR.right = headRR;
        new SymmetricTree().isSymmetric(head);
    }

    public boolean isSymmetric(TreeNode root) {
//    101. Symmetric Tree
        String left = traverseTreeLeft(root.left, "");
        String right = traverseTreeRight(root.right, "");
        if (left.equals(right))
            return true;
        return false;
    }

    public String traverseTreeLeft(TreeNode node, String str) {
        if (node == null)
            return "";
        String currentString = str + String.valueOf(node.val);
        currentString += traverseTreeLeft(node.left, "a") + traverseTreeLeft(node.right, "b");
        return currentString;
    }

    public String traverseTreeRight(TreeNode node, String str) {
        if (node == null)
            return "";
        String currentString = str + String.valueOf(node.val);
        currentString += traverseTreeRight(node.right, "a") + traverseTreeRight(node.left, "b");
        return currentString;
    }
}
