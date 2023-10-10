package LaiOffer.Class4_BinaryTree_BinarySearchTree;

import LaiOffer.TreeNode;

/**
 * Binary Tree Question 3: How to judge whether a binary tree is symmetric?
 * <p>
 * Time Complexity = O(n)
 * Space Complexity = O(height of the tree)
 */
public class BinaryTree_IsSymmetric {

    public static void main(String[] args) {
        int[] array1 = {10, 5, 15, 2, 7, 12, 20};
        TreeNode root1 = TreeNode.arrayToTree(array1);
        int[] array2 = {10, 5, 5, 2, 7, 7, 2};
        TreeNode root2 = TreeNode.arrayToTree(array2);
        System.out.println(isSymmetric(root1.left, root1.right));
        System.out.println(isSymmetric(root2.left, root2.right));
    }

    private static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        }

        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

}
