package SwordAtOffer.Tree;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ82 二叉树中和为某一值的路径(一)
 * 给定一个二叉树root和一个值 sum ，判断是否有从根节点到叶子节点的节点值之和等于 sum 的路径
 * 1.该题路径定义为从树的根结点开始往下一直到叶子结点所经过的结点
 * 2.叶子节点是指没有子节点的节点
 * 3.路径只能从父节点到子节点，不能从子节点到父节点
 * 4.总节点数目为n
 * 0 <= 节点数 <= 10000, 每个节点的值的绝对值 <= 1000
 * 空间复杂度O(n) or O(log n)，时间复杂度O(n)
 */

public class JZ82 {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * Method 1: Using recursion to keep track the tree and add the value to check whether equal to the target value
     * or not. Using deduction to do the operation.
     */
    public boolean hasPathSum1(TreeNode root, int sum) {
        //空节点找不到路径
        if (root == null)
            return false;
        //叶子节点，且路径和为sum
        if (root.left == null && root.right == null && sum - root.val == 0)
            return true;
        //递归进入子节点
        return hasPathSum1(root.left, sum - root.val) || hasPathSum1(root.right, sum - root.val);
    }

    /**
     * Method 2: DFS. Finding the route and record the value for route.
     */
    public boolean hasPathSum2(TreeNode root, int sum) {
        //空节点找不到路径
        if (root == null)
            return false;
        //栈辅助深度优先遍历
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        //跟随s1记录到相应节点为止的路径和
        Stack<Integer> s2 = new Stack<Integer>();
        s1.push(root);
        s2.push(root.val);
        while (!s1.isEmpty()) {
            //弹出相应节点
            TreeNode temp = s1.pop();
            //弹出到该点为止的当前路径和
            int cur_sum = s2.pop();
            //叶子节点且当前路径和等于sum
            if (temp.left == null && temp.right == null && cur_sum == sum)
                return true;
            //左节点及路径和入栈
            if (temp.left != null) {
                s1.push(temp.left);
                s2.push(cur_sum + temp.left.val);
            }
            //右节点及路径和入栈
            if (temp.right != null) {
                s1.push(temp.right);
                s2.push(cur_sum + temp.right.val);
            }
        }
        return false;
    }

}
