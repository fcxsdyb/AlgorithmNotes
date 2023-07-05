package Tree;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ54 二叉搜索树的第k个节点
 * 给定一棵结点数为n 二叉搜索树，请找出其中的第 k 小的TreeNode结点值
 * 1.返回第k小的节点值即可
 * 2.不能查找的情况，如二叉树为空，则返回-1，或者k大于n等等，也返回-1
 * 3.保证n个节点的值不一样
 * 0 <= n <= 1000, 0 <= k <= 1000, 0 <= 树上的每个结点的值 <= 1000
 * 空间复杂度O(n)，时间复杂度O(n)
 */

public class JZ54 {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * Method 1: Using inorder traversal to divide the binary search tree into the sorted order. During the process
     * check the kth node.
     */
    //记录返回的节点
    private TreeNode res = null;
    //记录中序遍历了多少个
    private int count = 0;

    public void midOrder(TreeNode root, int k) {
        //当遍历到节点为空或者超过k时，返回
        if (root == null || count > k)
            return;
        midOrder(root.left, k);
        count++;
        //只记录第k个
        if (count == k)
            res = root;
        midOrder(root.right, k);
    }

    public int KthNode1(TreeNode proot, int k) {
        midOrder(proot, k);
        if (res != null)
            return res.val;
            //二叉树为空，或是找不到
        else
            return -1;
    }

    /**
     * Method 2: Using stack to build up inorder traversal.
     */
    public int KthNode2(TreeNode proot, int k) {
        if (proot == null)
            return -1;
        //记录遍历了多少个数
        int count = 0;
        TreeNode p = null;
        //用栈辅助建立中序
        Stack<TreeNode> s = new Stack<TreeNode>();
        while (!s.isEmpty() || proot != null) {
            while (proot != null) {
                s.push(proot);
                //中序遍历每棵子树从最左开始
                proot = proot.left;
            }
            p = s.pop();
            count++;
            //第k个直接返回
            if (count == k)
                return p.val;
            proot = p.right;
        }
        //没有找到
        return -1;
    }
}
