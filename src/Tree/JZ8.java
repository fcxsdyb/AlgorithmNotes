package Tree;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ8 二叉树的下一个结点
 * 给定一个二叉树其中的一个结点，请找出中序遍历顺序的下一个结点并且返回
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的next指针
 * n <= 100, 0 <= 每个节点的值 <= 1000
 * 空间复杂度O(1)，时间复杂度O(n)
 */

public class JZ8 {

    class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    /**
     * Method 1: Using recursion to find the inorder traversal and check the targeted node.
     */
    ArrayList<TreeLinkNode> nodes = new ArrayList<>();

    public TreeLinkNode GetNext1(TreeLinkNode pNode) {
        // 获取根节点
        TreeLinkNode root = pNode;
        while (root.next != null) root = root.next;

        // 中序遍历打造nodes
        InOrder(root);

        // 进行匹配
        int n = nodes.size();
        for (int i = 0; i < n - 1; i++) {
            TreeLinkNode cur = nodes.get(i);
            if (pNode == cur) {
                return nodes.get(i + 1);
            }
        }
        return null;
    }

    // 中序遍历
    void InOrder(TreeLinkNode root) {
        if (root != null) {
            InOrder(root.left);
            nodes.add(root);
            InOrder(root.right);
        }
    }

    /**
     * Method 2: Directly finding the node. Divide all the possible situations: 1.have right child node, return the next
     * right child the leftest node. 2.no right child and current node is the left child of the parent node, return
     * the parent node. 3.no right child and current node is the right child of the parent node, return the parent node
     * which is its parent node's left child.
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        // 情况一
        if (pNode.right != null) {
            TreeLinkNode rchild = pNode.right;
            // 一直找到右子树的最左下的结点为返回值
            while (rchild.left != null) rchild = rchild.left;
            return rchild;
        }

        // 情况二
        if (pNode.next != null && pNode.next.left == pNode) {
            return pNode.next;
        }

        // 情况三
        if (pNode.next != null) {
            TreeLinkNode ppar = pNode.next;
            // 沿着左上一直爬树，爬到当前结点是其父节点的左自己结点为止
            while (ppar.next != null && ppar.next.right == ppar) ppar = ppar.next;
            return ppar.next;
        }
        return null;
    }
}
