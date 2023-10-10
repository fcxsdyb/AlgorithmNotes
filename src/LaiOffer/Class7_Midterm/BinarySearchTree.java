package LaiOffer.Class7_Midterm;

import LaiOffer.TreeNode;

/**
 * Question 2. How to judge whether a binary tree is a binary search tree?
 * Assumption: the data is integer.
 * <p>
 * Time Complexity = O(n)
 * Space Complexity = O(n) Should be the height of the tree
 */
public class BinarySearchTree {

    /**
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(12);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(10);
        TreeNode node7 = new TreeNode(14);
        TreeNode node8 = new TreeNode(1);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;

        System.out.println(isValidBST(node1));
    }

}
