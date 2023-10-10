package LaiOffer.Class4_BinaryTree_BinarySearchTree;

import LaiOffer.TreeNode;

/**
 * Binary Search Tree Question 2: Print BST keys in the given range
 */
public class PrintRangeBST {

    public static void main(String[] args) {
        int[] array = {10, 5, 15, 2, 7, 12, 20};
        TreeNode root = TreeNode.arrayToTree(array);
        int min = 1, max = 16;
        printRangeBST(root, min, max);
    }

    private static void printRangeBST(TreeNode root, int min, int max) {
        if (root == null) {
            return;
        }

        if (root.val > min) {
            printRangeBST(root.left, min, max);
        }
        if (root.val > min && root.val < max) {
            System.out.print(root.val + " ");
        }
        if (root.val < max) {
            printRangeBST(root.right, min, max);
        }

    }

}
