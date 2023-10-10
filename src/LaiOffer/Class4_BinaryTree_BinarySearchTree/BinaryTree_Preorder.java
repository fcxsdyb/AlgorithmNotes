package LaiOffer.Class4_BinaryTree_BinarySearchTree;

import LaiOffer.TreeNode;

/**
 * Binary Tree Preorder
 */
public class BinaryTree_Preorder {

    public static void main(String[] args) {
        int[] array = {10, 5, 15, 2, 7, 12, 20};
        TreeNode root = TreeNode.arrayToTree(array);
        preorder(root);
    }

    private static void preorder(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

}
