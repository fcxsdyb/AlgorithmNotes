package SwordAtOffer.Tree;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ55 二叉树的深度
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度，根节点的深度视为1
 * 0 <= 节点数量 <= 100, 0 <= 节点值 <= 100
 * 空间复杂度O(1)，时间复杂度O(n)
 */

public class JZ55 {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * Method 1: Using recursion to solve the problem is the best way to solve this problem.
     */
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }

    /**
     * Method 2: Using queue to solve the problem. Traverse the whole tree and get the length.
     */
    public int maxDepth(TreeNode root) {
        //空节点没有深度
        if (root == null)
            return 0;
        //队列维护层次后续节点
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        //根入队
        q.offer(root);
        //记录深度
        int res = 0;
        //层次遍历
        while (!q.isEmpty()) {
            //记录当前层有多少节点
            int n = q.size();
            //遍历完这一层，再进入下一层
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                //添加下一层的左右节点
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
            //深度加1
            res++;
        }
        return res;
    }

}
