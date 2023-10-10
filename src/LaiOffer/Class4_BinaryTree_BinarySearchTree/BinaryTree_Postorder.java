package LaiOffer.Class4_BinaryTree_BinarySearchTree;

import LaiOffer.TreeNode;

/**
 * Binary Tree Postorder
 */
public class BinaryTree_Postorder {

    public static void main(String[] args) {
        int[] array = {10, 5, 15, 2, 7, 12, 20};
        TreeNode root = TreeNode.arrayToTree(array);
        postorder(root);
    }

    private static void postorder(TreeNode root) {
        if (root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }

}
