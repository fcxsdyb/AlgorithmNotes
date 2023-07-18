package SwordAtOffer.Tree;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ77 按之字形顺序打印二叉树
 * 给定一个二叉树，返回该二叉树的之字形层序遍历，（第一层从左向右，下一层从右向左，一直这样交替）
 * 0 <= n <= 1500, 树上的节点值的绝对值 <= 1500
 * 空间复杂度O(n)，时间复杂度O(n)
 */

public class JZ77 {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * Method 1: Using queue to read all the tree node length by length. Count them and check whether length is odd or
     * even. And if odd, reverse the list then add to the final result list.
     */
    public ArrayList<ArrayList<Integer>> Print1(TreeNode pRoot) {
        TreeNode head = pRoot;
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (head == null)
            //如果是空，则直接返回空list
            return res;
        //队列存储，进行层次遍历
        Queue<TreeNode> temp = new LinkedList<TreeNode>();
        temp.offer(head);
        TreeNode p;
        boolean flag = true;
        while (!temp.isEmpty()) {
            //记录二叉树的某一行
            ArrayList<Integer> row = new ArrayList<Integer>();
            int n = temp.size();
            //奇数行反转，偶数行不反转
            flag = !flag;
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
            //奇数行反转，偶数行不反转
            if (flag)
                Collections.reverse(row);
            res.add(row);
        }
        return res;
    }

    /**
     * Method 2: Using stack to read the tree and separate them into odd stack and even stack. Using different way to
     * do the output.
     */
    public ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot) {
        TreeNode head = pRoot;
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (head == null)
            //如果是空，则直接返回空list
            return res;
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        //放入第一次
        s1.push(head);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            //遍历奇数层
            while (!s1.isEmpty()) {
                TreeNode node = s1.pop();
                //记录奇数层
                temp.add(node.val);
                //奇数层的子节点加入偶数层
                if (node.left != null)
                    s2.push(node.left);
                if (node.right != null)
                    s2.push(node.right);
            }
            //数组不为空才添加
            if (temp.size() != 0)
                res.add(new ArrayList<Integer>(temp));
            //清空本层数据
            temp.clear();
            //遍历偶数层
            while (!s2.isEmpty()) {
                TreeNode node = s2.pop();
                //记录偶数层
                temp.add(node.val);
                //偶数层的子节点加入奇数层
                if (node.right != null)
                    s1.push(node.right);
                if (node.left != null)
                    s1.push(node.left);
            }
            //数组不为空才添加
            if (temp.size() != 0)
                res.add(new ArrayList<Integer>(temp));
            //清空本层数据
            temp.clear();
        }
        return res;
    }
}
