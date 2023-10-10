package LaiOffer.Class5_Heap_GraphSearchAlgorithms_I;

import LaiOffer.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree_IsCompleteBinaryTree {

    public static void main(String[] args) {
        int[] array = {10, 5, 15, 2, 7, 12, 20};
        TreeNode root = TreeNode.arrayToTree(array);
        System.out.println(isCBT(root));
        root.right.right.left = new TreeNode(17);
        System.out.println(isCBT(root));
    }

    private static boolean isCBT(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        boolean check = false;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null && !check) {
                    queue.offer(node.left);
                } else if (node.left != null && check) {
                    return false;
                } else {
                    check = true;
                }

                if (node.right != null && !check) {
                    queue.offer(node.right);
                } else if (node.right != null && check) {
                    return false;
                } else {
                    check = true;
                }
            }
        }
        return check;
    }

}
