package LaiOffer.Class4_BinaryTree_BinarySearchTree;

import LaiOffer.TreeNode;

/**
 * Binary Search Tree Question 1: How to determine a binary tree is a BST?
 * Primitive Idea:
 * For each node,
 * check all its left-subtree, to determine whether they are all smaller
 * check all its right-subtree, to determine whether they are all larger
 */
public class IsBinarySearchTree {

    public static void main(String[] args) {
        int[] array = {10, 5, 15, 2, 7, 12, 20};
        TreeNode root = TreeNode.arrayToTree(array);
        System.out.println(isBST(root));
    }

    private static boolean isBST(TreeNode root) {
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isBST(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }

        if (root.val > minValue && root.val < maxValue) {
            return isBST(root.left, minValue, root.val) && isBST(root.right, root.val, maxValue);
        } else {
            return false;
        }
    }

}
