package SwordAtOffer.Tree;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ86 在二叉树中找到两个节点的最近公共祖先
 * 给定一棵二叉树(保证非空)以及这棵树上的两个节点对应的val值 o1 和 o2，请找到 o1 和 o2 的最近公共祖先节点
 * 1 <= 节点数 n <= 10^5, 0 <= 节点值 < n
 * 时间复杂度O(n)
 */

public class JZ86 {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * Method 1: Using dfs to find the route for both nodes, compare each bit and get the result.
     */
    //记录是否找到到o的路径
    public boolean flag = false;

    //求得根节点到目标节点的路径
    public void dfs(TreeNode root, ArrayList<Integer> path, int o) {
        if (flag || root == null)
            return;
        path.add(root.val);
        //节点值都不同，可以直接用值比较
        if (root.val == o) {
            flag = true;
            return;
        }
        //dfs遍历查找
        dfs(root.left, path, o);
        dfs(root.right, path, o);
        //找到
        if (flag)
            return;
        //回溯
        path.remove(path.size() - 1);
    }

    public int lowestCommonAncestor1(TreeNode root, int o1, int o2) {
        ArrayList<Integer> path1 = new ArrayList<Integer>();
        ArrayList<Integer> path2 = new ArrayList<Integer>();
        //求根节点到两个节点的路径
        dfs(root, path1, o1);
        //重置flag，查找下一个
        flag = false;
        dfs(root, path2, o2);
        int res = 0;
        //比较两个路径，找到第一个不同的点
        for (int i = 0; i < path1.size() && i < path2.size(); i++) {
            int x = path1.get(i);
            int y = path2.get(i);
            if (x == y)
                //最后一个相同的节点就是最近公共祖先
                res = x;
            else
                break;
        }
        return res;
    }

    /**
     * Method 2: Using recursion to separate this question into all possibility. 1. if public root is the root, then
     * two nodes should be one in the left and another in right. 2. if two nodes in left or right, using recursion to
     * find the root like the previous doing. Keep checking and get the result.
     */
    public int lowestCommonAncestor2(TreeNode root, int o1, int o2) {
        //该子树没找到，返回-1
        if (root == null)
            return -1;
        //该节点是其中某一个节点
        if (root.val == o1 || root.val == o2)
            return root.val;
        //左子树寻找公共祖先
        int left = lowestCommonAncestor2(root.left, o1, o2);
        //右子树寻找公共祖先
        int right = lowestCommonAncestor2(root.right, o1, o2);
        //左子树为没找到，则在右子树中
        if (left == -1)
            return right;
        //右子树没找到，则在左子树中
        if (right == -1)
            return left;
        //否则是当前节点
        return root.val;
    }
}
