package SwordAtOffer.Tree;

import java.util.*;

/**
 * 剑指Offer
 * JZ26 树的子结构
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（我们约定空树不是任意一个树的子结构）
 * 假如给定A为{8,8,7,9,2,#,#,#,#,4,7}，B为{8,9,2}，2个树的结构如下，可以看出B是A的子结构
 * 0 <= A的节点个数 <= 10000, 0 <= B的节点个数 <= 10000
 */

public class JZ26 {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * Method 1: Traverse each node in the tree node 1 and try to compare with targeted tree node 2. Using recursion to
     * find each node whether match tree node 2 structure or not.
     */
    private boolean recursion(TreeNode root1, TreeNode root2) {
        //当一个节点存在另一个不存在时
        if (root1 == null && root2 != null)
            return false;
        //两个都为空则返回
        if (root2 == null)
            return true;
        //比较节点值
        if (root1.val != root2.val)
            return false;
        //递归比较子树
        return recursion(root1.left, root2.left) && recursion(root1.right, root2.right);
    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        //空树
        if (root2 == null)
            return false;
        //一个为空，另一个不为空
        if (root1 == null)
            return false;
        //递归比较
        boolean flag1 = recursion(root1, root2);
        //递归树1的每个节点
        boolean flag2 = HasSubtree(root1.left, root2);
        boolean flag3 = HasSubtree(root1.right, root2);
        return flag1 || flag2 || flag3;
    }

    /**
     * Method 2: Using queue to judge whether a node is the same as the root node of tree node 2. If yes, do the same
     * check and do the check for child tree. Keep compare all the nodes by the queue.
     */
    //层次遍历判断两个树是否相同
    private boolean helper(TreeNode root1, TreeNode root2) {
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();
        q1.offer(root1);
        q2.offer(root2);
        //以树2为基础，树1跟随就可以了
        while (!q2.isEmpty()) {
            TreeNode node1 = q1.poll();
            TreeNode node2 = q2.poll();
            //树1为空或者二者不相等
            if (node1 == null || node1.val != node2.val)
                return false;
            //树2还有左子树
            if (node2.left != null) {
                //子树入队
                q1.offer(node1.left);
                q2.offer(node2.left);
            }
            //树2还有右子树
            if (node2.right != null) {
                //子树入队
                q1.offer(node1.right);
                q2.offer(node2.right);
            }
        }
        return true;
    }

    public boolean HasSubtree1(TreeNode root1, TreeNode root2) {
        //空树不为子结构
        if (root1 == null || root2 == null)
            return false;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root1);
        //层次遍历树1
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            //遇到与树2根相同的节点，以这个节点为根判断后续子树是否相同
            if (node.val == root2.val) {
                if (helper(node, root2))
                    return true;
            }
            //左子树入队
            if (node.left != null)
                q.offer(node.left);
            //右子树入队
            if (node.right != null)
                q.offer(node.right);
        }
        return false;
    }

}
