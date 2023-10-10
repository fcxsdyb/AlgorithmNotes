package LaiOffer.Class4_BinaryTree_BinarySearchTree;

import LaiOffer.TreeNode;

import static LaiOffer.Class4_BinaryTree_BinarySearchTree.BinaryTree_GetHeight.getHeight;

/**
 * Binary Tree Question 2: How to determine whether a binary tree is a balanced binary tree?
 * <p>
 * Time Complexity = O(n log n) if the tree is balanced
 * Space Complexity = O(log n) if the tree is balanced
 */
public class BinaryTree_IsBalancedBinaryTree {

    public static void main(String[] args) {
        int[] array = {10, 5, 15, 2, 7, 12, 20};
        TreeNode root = TreeNode.arrayToTree(array);
        System.out.println(isBalancedTree(root));
    }

    private static boolean isBalancedTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if (Math.abs(left - right) > 1) {
            return false;
        }
        return isBalancedTree(root.left) && isBalancedTree(root.right);
    }

}
