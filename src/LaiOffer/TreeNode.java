package LaiOffer;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {

    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    // Convert array to binary tree.
    public static TreeNode arrayToTree(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        return createNode(array, 0);
    }

    // Helper function to create nodes recursively.
    private static TreeNode createNode(int[] array, int index) {
        if (index >= array.length) {
            return null;
        }

        TreeNode node = new TreeNode(array[index]);
        node.left = createNode(array, 2 * index + 1);
        node.right = createNode(array, 2 * index + 2);

        return node;
    }

    public static void printTreeNode(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.val + " ");
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

}
