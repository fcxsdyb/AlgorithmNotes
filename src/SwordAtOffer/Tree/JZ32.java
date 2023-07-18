package SwordAtOffer.Tree;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ32 从上往下打印二叉树
 * 不分行从上往下打印出二叉树的每个节点，同层节点从左至右打
 * 例如输入{8,6,10,#,#,2,1}，如以下图中的示例二叉树，则依次打印8,6,10,2,1(空节点不打印，跳过)
 * 0 <= 节点数 <= 1000, -1000 <= 每个节点的值 <= 1000
 */

public class JZ32 {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * Method 1: Using queue to read node's child from root to the bottom. Add each child to the queue, and pop item
     * from the queue.
     */
    public ArrayList<Integer> PrintFromTopToBottom1(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null)
            //如果是空，则直接返回空数组
            return res;
        //队列存储，进行层次遍历
        Queue<TreeNode> q = new ArrayDeque<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            res.add(cur.val);
            //若是左右孩子存在，则存入左右孩子作为下一个层次
            if (cur.left != null)
                q.add(cur.left);
            if (cur.right != null)
                q.add(cur.right);
        }
        return res;
    }

    /**
     * Method 2: Using recursion add nodes value level by level.
     */
    public void traverse(TreeNode root, ArrayList<ArrayList<Integer>> res, int depth) {
        if (root != null) {
            //新的一层
            ArrayList<Integer> row;
            if (res.size() < depth) {
                row = new ArrayList<>();
                res.add(row);
                //读取该层的一维数组，将元素加入末尾
            } else {
                row = res.get(depth - 1);
            }
            row.add(root.val);
        } else
            return;
        //递归左右时深度记得加1
        traverse(root.left, res, depth + 1);
        traverse(root.right, res, depth + 1);
    }

    public ArrayList<Integer> PrintFromTopToBottom2(TreeNode root) {
        ArrayList<Integer> res = new ArrayList();
        ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            //如果是空，则直接返回
            return res;
        //递归层次遍历
        traverse(root, temp, 1);
        //送入一维数组
        for (ArrayList<Integer> integers : temp)
            res.addAll(integers);
        return res;
    }
}
