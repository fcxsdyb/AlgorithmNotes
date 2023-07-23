package LeetCodeHot100;

/**
 * 104.二叉树的最大深度
 */

public class Q42 {

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

    public int maxDepth(TreeNode root) {
        int depth = 0;
        if (root != null) {
            depth += 1;
        } else {
            return depth;
        }

        return Math.max(DepthCheck(root.left, depth), DepthCheck(root.right, depth));
    }

    public int DepthCheck(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        depth++;
        return Math.max(DepthCheck(root.left, depth), DepthCheck(root.right, depth));
    }

    /**
     * Better Way
     */
    public int maxDepth1(TreeNode root) {
        if(root == null) {
            return 0;
        } else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }

}
