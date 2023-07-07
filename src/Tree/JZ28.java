package Tree;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ28 对称的二叉树
 * 给定一棵二叉树，判断其是否是自身的镜像
 * 0 <= n <= 1000, 每个节点的值的绝对值 <= 1000
 * 空间复杂度O(n)，时间复杂度O(n)
 */

public class JZ28 {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * Method 1: Using recursion by the rule of preorder traversal.
     */
    boolean recursion(TreeNode root1, TreeNode root2) {
        //可以两个都为空
        if (root1 == null && root2 == null)
            return true;
        //只有一个为空或者节点值不同，必定不对称
        if (root1 == null || root2 == null || root1.val != root2.val)
            return false;
        //每层对应的节点进入递归比较
        return recursion(root1.left, root2.right) && recursion(root1.right, root2.left);
    }

    boolean isSymmetrical(TreeNode pRoot) {
        return recursion(pRoot, pRoot);
    }

    /**
     * Method 2: Using queue to add nodes into queue. And compare nodes and pop out.
     */
    boolean isSymmetrical2(TreeNode pRoot) {
        //空树为对称的
        if (pRoot == null)
            return true;
        //辅助队列用于从两边层次遍历
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();
        q1.offer(pRoot.left);
        q2.offer(pRoot.right);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            //分别从左边和右边弹出节点
            TreeNode left = q1.poll();
            TreeNode right = q2.poll();
            //都为空暂时对称
            if (left == null && right == null)
                continue;
            //某一个为空或者数字不相等则不对称
            if (left == null || right == null || left.val != right.val)
                return false;
            //从左往右加入队列
            q1.offer(left.left);
            q1.offer(left.right);
            //从右往左加入队列
            q2.offer(right.right);
            q2.offer(right.left);
        }
        //都检验完都是对称的
        return true;
    }
}
