package Tree;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ79 判断是不是平衡二叉树
 * 输入一棵节点数为 n 二叉树，判断该二叉树是否是平衡二叉树
 * 平衡二叉树（Balanced Binary Tree），具有以下性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树
 * n <= 100, 0 <= 每个节点的值 <= 1000
 * 空间复杂度O(1)，时间复杂度O(n)
 */

public class JZ79 {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * Method 1: Using recursion from top to bottom finding the length for each node. Calculate the result and get the
     * final answer.
     */
    //计算该子树深度函数
    public int deep(TreeNode root) {
        //空节点深度为0
        if (root == null)
            return 0;
        //递归算左右子树的深度
        int left = deep(root.left);
        int right = deep(root.right);
        //子树最大深度加上自己
        return (left > right) ? left + 1 : right + 1;
    }

    public boolean IsBalanced_Solution1(TreeNode root) {
        //空树为平衡二叉树
        if (root == null)
            return true;
        int left = deep(root.left);
        int right = deep(root.right);
        //左子树深度减去右子树相差绝对值大于1
        if (left - right > 1 || left - right < -1)
            return false;
        //同时，左右子树还必须是平衡的
        return IsBalanced_Solution1(root.left) && IsBalanced_Solution1(root.right);
    }

    /**
     * Method 2: Using recursion from the bottom to the top.
     */
    public boolean IsBalanced_Solution2(TreeNode root) {
        //空树也是平衡二叉树
        if (root == null)
            return true;
        return getdepth(root) != -1;
    }

    public int getdepth(TreeNode root) {
        if (root == null)
            return 0;
        //递归计算当前root左右子树的深度差
        int left = getdepth(root.left);
        //当前节点左子树不平衡，则该树不平衡
        if (left < 0)
            return -1;
        int right = getdepth(root.right);
        //当前节点右子树不平衡，则该树不平衡
        if (right < 0)
            return -1;
        //计算深度差
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }
}
