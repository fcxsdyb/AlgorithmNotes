package Tree;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ7 重建二叉树
 * 给定一棵结点数为n 二叉搜索树，请找出其中的第 k 小的TreeNode结点值
 * 1.返回第k小的节点值即可
 * 2.不能查找的情况，如二叉树为空，则返回-1，或者k大于n等等，也返回-1
 * 3.保证n个节点的值不一样
 * 0 <= n <= 1000, 0 <= k <= 1000, 0 <= 树上的每个结点的值 <= 1000
 * 空间复杂度O(n)，时间复杂度O(n)
 */

public class JZ7 {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * Method 1: Using recursion to build up a tree with preorder and inorder traversal. Based on the logical, in a tree
     * the first element of the tree is the root in preorder traversal. And in inorder traversal, the node in
     * preorder between the second element to the length find the root in the inorder should be the left part.
     * And the rest part for the preorder should be the right part. Furthermore, using the preorder and inorder
     * traversal at the same time to do the root check and child found.
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] vin) {
        int n = pre.length;
        int m = vin.length;
        //每个遍历都不能为0
        if (n == 0 || m == 0)
            return null;
        //构建根节点
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < vin.length; i++) {
            //找到中序遍历中的前序第一个元素
            if (pre[0] == vin[i]) {
                //构建左子树
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(vin, 0, i));
                //构建右子树
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(vin, i + 1, vin.length));
                break;
            }
        }
        return root;
    }

    /**
     * Method 2: Using stack to build up the tree.
     */
    public TreeNode reConstructBinaryTree2(int[] pre, int[] vin) {
        int n = pre.length;
        int m = vin.length;
        //每个遍历都不能为0
        if (n == 0 || m == 0)
            return null;
        Stack<TreeNode> s = new Stack<TreeNode>();
        //首先建立前序第一个即根节点
        TreeNode root = new TreeNode(pre[0]);
        TreeNode cur = root;
        for (int i = 1, j = 0; i < n; i++) {
            //要么旁边这个是它的左节点
            if (cur.val != vin[j]) {
                cur.left = new TreeNode(pre[i]);
                s.push(cur);
                //要么旁边这个是它的右节点，或者祖先的右节点
                cur = cur.left;
            } else {
                j++;
                //弹出到符合的祖先
                while (!s.isEmpty() && s.peek().val == vin[j]) {
                    cur = s.pop();
                    j++;
                }
                //添加右节点
                cur.right = new TreeNode(pre[i]);
                cur = cur.right;
            }
        }
        return root;
    }
}
