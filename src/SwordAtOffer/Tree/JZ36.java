package SwordAtOffer.Tree;

import java.util.*;

/**
 * 剑指Offer
 * JZ36 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表
 * 0 <= 节点数 <= 1000, 0 <= 每个节点的值 <= 1000
 * 空间复杂度O(1)，时间复杂度O(n)
 */

public class JZ36 {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * Method 1: Using recursion to do the tree traversal. Based on the characteristics of BST, inorder traversal of
     * the tree would be the final result.
     */
    //返回的第一个指针，即为最小值，先定为null
    public TreeNode head = null;
    //中序遍历当前值的上一位，初值为最小值，先定为null
    public TreeNode pre = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            //中序递归，叶子为空则返回
            return null;
        //首先递归到最左最小值
        Convert(pRootOfTree.left);
        //找到最小值，初始化head与pre
        if (pre == null) {
            head = pRootOfTree;
            pre = pRootOfTree;
        }
        //当前节点与上一节点建立连接，将pre设置为当前值
        else {
            pre.right = pRootOfTree;
            pRootOfTree.left = pre;
            pre = pRootOfTree;
        }
        Convert(pRootOfTree.right);
        return head;
    }

    /**
     * Method 2: Using stack to do the same function.
     */
    public TreeNode Convert2(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return null;
        //设置栈用于遍历
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode head = null;
        TreeNode pre = null;
        //确认第一个遍历到最左，即为首位
        boolean isFirst = true;
        while (pRootOfTree != null || !s.isEmpty()) {
            //直到没有左节点
            while (pRootOfTree != null) {
                s.push(pRootOfTree);
                pRootOfTree = pRootOfTree.left;
            }
            pRootOfTree = s.pop();
            //最左元素即表头
            if (isFirst) {
                head = pRootOfTree;
                pre = head;
                isFirst = false;
                //当前节点与上一节点建立连接，将pre设置为当前值
            } else {
                pre.right = pRootOfTree;
                pRootOfTree.left = pre;
                pre = pRootOfTree;
            }
            pRootOfTree = pRootOfTree.right;
        }
        return head;
    }
}
