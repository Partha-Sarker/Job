package leetcode;

public class Test {
    public static TreeNode createTreeFromArray(Integer[] array) {
        int len = array.length;
        if (len == 0)
            return null;
        TreeNode[] nodes = new TreeNode[len];
        nodes[0] = new TreeNode(array[0]);
        for (int i = 1; i < array.length; i++) {
            if (array[i] == null)
                continue;

            int parentIndex = (i - 1) / 2;
            nodes[i] = new TreeNode(array[i]);

            try {
                if (i == 2 * parentIndex + 1)
                    nodes[parentIndex].left = nodes[i];
                else
                    nodes[parentIndex].right = nodes[i];
            } catch (Exception e) {
//                test.Test.printStuffs(i, parentIndex);
            }
        }

        return nodes[0];
    }

    public static void main(String[] args) {
        Integer[] array = {-2, null, -3};
        TreeNode root = createTreeFromArray(array);
        hasPathSum(root, 0, -5);
    }

    public static boolean hasPathSum(TreeNode node, int currentSum, int targetSum) {
        if (currentSum > targetSum)
            return false;
        if (node.left == null && node.right == null) {
            if (currentSum + node.val == targetSum)
                return true;
            return false;
        }
        boolean hasLeftSum = false, hasRightSum = false;
        if (node.left != null)
            hasLeftSum = hasPathSum(node.left, node.val + currentSum, targetSum);
        if (node.right != null)
            hasRightSum = hasPathSum(node.right, node.val + currentSum, targetSum);
        return hasLeftSum || hasRightSum;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
