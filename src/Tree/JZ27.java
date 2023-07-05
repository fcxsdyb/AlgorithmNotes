package Tree;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ27 二叉树的镜像
 * 操作给定的二叉树，将其变换为源二叉树的镜像
 * 0 <= 二叉树的节点数 <= 1000, 0 <= 每个节点的值 <= 1000
 * 空间复杂度O(n) or O(1)，时间复杂度O(n)
 */

public class JZ27 {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * Method 1: Using recursion to find the smallest child node and do the swap for its left child and right child.
     * Based on the recursion, each node will do the swap step by step and finally return the target tree.
     */
    public TreeNode Mirror1(TreeNode pRoot) {
        //空树返回
        if (pRoot == null)
            return null;
        //先递归子树
        TreeNode left = Mirror1(pRoot.left);
        TreeNode right = Mirror1(pRoot.right);
        //交换
        pRoot.left = right;
        pRoot.right = left;
        return pRoot;
    }

    /**
     * Method 2: Using stack from root to the bottom adding nodes. Switch left and right child and continue this step
     * in the next level of the tree.
     */
    public TreeNode Mirror2(TreeNode pRoot) {
        //空树
        if (pRoot == null)
            return null;
        //辅助栈
        Stack<TreeNode> s = new Stack<TreeNode>();
        //根节点先进栈
        s.push(pRoot);
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            //左右节点入栈
            if (node.left != null)
                s.push(node.left);
            if (node.right != null)
                s.push(node.right);
            //交换左右
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return pRoot;
    }
}
