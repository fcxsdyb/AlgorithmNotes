package LaiOffer.Class4_BinaryTree_BinarySearchTree;

import LaiOffer.TreeNode;

/**
 * Binary Tree Question 1: get the height of a binary tree
 * <p>
 * Time Complexity = O(n)
 * Space Complexity = O(height of the tree)
 */
public class BinaryTree_GetHeight {

    public static void main(String[] args) {
        int[] array = {10, 5, 15, 2, 7, 12, 20, 1};
        TreeNode root = TreeNode.arrayToTree(array);
        System.out.println(getHeight(root));
    }

    static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left, right) + 1;
    }

}
