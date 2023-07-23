package LeetCodeHot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 94.二叉树的中序遍历
 */

public class Q37 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        recur(res, root);
        return res;
    }

    public void recur(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }

        recur(res, root.left);
        res.add(root.val);
        recur(res, root.right);
    }

}
