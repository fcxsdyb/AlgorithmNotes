package SwordAtOffer.Tree;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ78 把二叉树打印成多行
 * 给定一个节点数为 n 二叉树，要求从上到下按层打印二叉树的 val 值，同一层结点从左至右输出，每一层输出一行，将输出的结果存放到一个二维数组中返回
 * 0 <= n <= 1000, 0 <= 每个节点的值 <= 1000
 * 空间复杂度O(n)，时间复杂度O(n)
 */

public class JZ78 {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * Method 1: Using queue to read all the nodes in the tree
     */
    //层次遍历
    public ArrayList<ArrayList<Integer>> Print1(TreeNode pRoot) {
        TreeNode head = pRoot;
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (head == null)
            //如果是空，则直接返回空数组
            return res;
        //队列存储，进行层次遍历
        Queue<TreeNode> temp = new LinkedList<TreeNode>();
        temp.offer(head);
        TreeNode p;
        while (!temp.isEmpty()) {
            //记录二叉树的某一行
            ArrayList<Integer> row = new ArrayList<Integer>();
            int n = temp.size();
            //因先进入的是根节点，故每层节点多少，队列大小就是多少
            for (int i = 0; i < n; i++) {
                p = temp.poll();
                row.add(p.val);
                //若是左右孩子存在，则存入左右孩子作为下一个层次
                if (p.left != null)
                    temp.offer(p.left);
                if (p.right != null)
                    temp.offer(p.right);
            }
            res.add(row);
        }
        return res;
    }

    /**
     * Method 2: Using recursion to add nodes by the same depth.
     */
    private void traverse(TreeNode root, ArrayList<ArrayList<Integer>> res, int depth) {
        if (root != null) {
            //数组长度小于当前层数，新开一层
            if (res.size() < depth)
                res.add(new ArrayList<Integer>());
            //数组从0开始计数因此减1，在节点当前层的数组中插入节点
            res.get(depth - 1).add(root.val);
            //递归左右时节点深度记得加1
            traverse(root.left, res, depth + 1);
            traverse(root.right, res, depth + 1);
        }
    }

    //层次遍历
    public ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        //树的层级从1开始递归计数
        traverse(pRoot, res, 1);
        return res;
    }
}
