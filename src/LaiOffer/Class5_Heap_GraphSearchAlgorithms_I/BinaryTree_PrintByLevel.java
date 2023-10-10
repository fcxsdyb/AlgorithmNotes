package LaiOffer.Class5_Heap_GraphSearchAlgorithms_I;

import LaiOffer.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Breadth First Search
 */
public class BinaryTree_PrintByLevel {

    public static void main(String[] args) {
        int[] array = {10, 5, 15, 2, 7, 12, 20};
        TreeNode root = TreeNode.arrayToTree(array);
        printByLevel(root);
    }

    private static void printByLevel(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                System.out.print(node.val + " ");
            }
            System.out.println();
        }
    }

}
