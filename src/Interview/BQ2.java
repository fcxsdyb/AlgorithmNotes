package Interview;

public class BQ2 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int maxPath = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        findPath(root, root.val);
        return maxPath;
    }

    private int findPath(TreeNode node, int val) {
        if (node == null) return 0;
        int left = findPath(node.left, node.val);
        int right = findPath(node.right, node.val);
        maxPath = Math.max(maxPath, left + right); // update the global max
        if (node.val == val) return Math.max(left, right) + 1;
        return 0;
    }
}
