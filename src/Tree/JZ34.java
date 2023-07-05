package Tree;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ34 二叉树中和为某一值的路径(二)
 * 输入一颗二叉树的根节点root和一个整数expectNumber，找出二叉树中结点值的和为expectNumber的所有路径
 * 1.该题路径定义为从树的根结点开始往下一直到叶子结点所经过的结点
 * 2.叶子节点是指没有子节点的节点
 * 3.路径只能从父节点到子节点，不能从子节点到父节点
 * 4.总节点数目为n
 * 0 <= 节点数 <= 5000, 每个节点的值的绝对值 <= 1000, expectNumber的绝对值 <= 1000
 */

public class JZ34 {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * Method 1: Using dfs to divide tree into several path with value. Compare the value and find the track.
     */
    private ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    void dfs(TreeNode root, int number) {
        // 处理树为空
        if (root == null) return;
        // 路径更新
        path.add(root.val);
        // number更新
        number -= root.val;
        // 如果递归当前节点为叶子节点且该条路径的值已经达到了expectNumber，则更新ret
        if (root.left == null && root.right == null && number == 0) {
            ret.add(new ArrayList<>(path));
        }
        // 左右子树递归
        dfs(root.left, number);
        dfs(root.right, number);
        path.removeLast();
    }

    public ArrayList<ArrayList<Integer>> FindPath1(TreeNode root, int expectNumber) {
        dfs(root, expectNumber);
        return ret;
    }

    /**
     * Method 2: Using bfs to traverse all the route and find all the child node. Calculate the value and compare.
     */
    public ArrayList<ArrayList<Integer>> FindPath2(TreeNode root, int expectNumber) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (root == null) return ret;
        Queue<ArrayList<Integer>> pathQ = new LinkedList<ArrayList<Integer>>();
        Queue<TreeNode> nodeQ = new LinkedList<TreeNode>();
        pathQ.offer(new ArrayList<Integer>(Arrays.asList(root.val)));
        nodeQ.offer(root);

        while (!nodeQ.isEmpty()) {
            ArrayList<Integer> curpath = pathQ.poll();
            TreeNode curnode = nodeQ.poll();
            if (curnode.left != null) {
                ArrayList<Integer> left = new ArrayList<Integer>(curpath);
                left.add(curnode.left.val);
                pathQ.offer(left);
                nodeQ.offer(curnode.left);
            }
            // 右子节点path
            if (curnode.right != null) {
                ArrayList<Integer> right = new ArrayList<Integer>(curpath);
                right.add(curnode.right.val);
                pathQ.offer(right);
                nodeQ.offer(curnode.right);
            }
            // 叶子节点统计
            if (curnode.left == null && curnode.right == null) {
                ArrayList<Integer> l = curpath;
                int sum = 0;
                for (int i = 0; i < l.size(); i++) {
                    sum = sum + l.get(i);
                }
                if (sum == expectNumber) ret.add(l);
            }
        }
        return ret;
    }
}
