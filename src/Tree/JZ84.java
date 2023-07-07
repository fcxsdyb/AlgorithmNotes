package Tree;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ84 二叉树中和为某一值的路径(三)
 * 给定一个二叉树root和一个整数值sum ，求该树有多少路径的的节点值之和等于sum
 * 1.该题路径定义不需要从根节点开始，也不需要在叶子节点结束，但是一定是从父亲节点往下到孩子节点
 * 2.总节点数目为n
 * 3.保证最后返回的路径个数在整形范围内(即路径个数小于2^31-1)
 * 0 <= n <= 1000, -10^9 <= 节点值 <= 10^9
 * 空间复杂度O(n)，时间复杂度O(n)
 */

public class JZ84 {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * Method 1: Using two recursion, one for calculating the nodes value, one for calculate the roots based on the
     * question.
     */
    private int res = 0;

    //dfs查询以某结点为根的路径数
    private void dfs(TreeNode root, int sum) {
        if (root == null)
            return;
        //符合目标值
        if (sum == root.val)
            res++;
        //进入子节点继续找
        dfs(root.left, sum - root.val);
        dfs(root.right, sum - root.val);
    }

    //dfs 以每个结点作为根查询路径
    public int FindPath1(TreeNode root, int sum) {
        //为空则返回
        if (root == null)
            return res;
        //查询以某结点为根的路径数
        dfs(root, sum);
        //以其子结点为新根
        FindPath1(root.left, sum);
        FindPath1(root.right, sum);
        return res;
    }

    /**
     * Method 2: Using hashtable to solve the problem. Count every possible value for all the routes. If meet a new
     * value, create 1 line in the hashtable, otherwise, directly add one into the original created value.
     */
    //记录路径和及条数
    private HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();

    //last为到上一层为止的累加和
    private int dfs(TreeNode root, int sum, int last) {
        //空结点直接返回
        if (root == null)
            return 0;
        int res = 0;
        //到目前结点为止的累加和
        int temp = root.val + last;
        //如果该累加和减去sum在哈希表中出现过，相当于减去前面的分支
        if (mp.containsKey(temp - sum))
            //加上有的路径数
            res += mp.get(temp - sum);
        //增加该次路径和
        mp.put(temp, mp.getOrDefault(temp, 0) + 1);
        //进入子结点
        res += dfs(root.left, sum, temp);
        res += dfs(root.right, sum, temp);
        //回退该路径和，因为别的树枝不需要这边存的路径和
        mp.put(temp, mp.get(temp) - 1);
        return res;
    }

    public int FindPath2(TreeNode root, int sum) {
        //路径和为0的有1条
        mp.put(0, 1);
        return dfs(root, sum, 0);
    }
}
