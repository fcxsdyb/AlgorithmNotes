package LeetCodeHot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 437.路径总和III
 */

public class Q87 {

    static class TreeNode {
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

    Map<Long, Integer> prefixMap;
    int target;

    public int pathSum(TreeNode root, int targetSum) {
        prefixMap = new HashMap<>();
        target = targetSum;
        prefixMap.put(0L, 1);  //key是前缀和，value是前缀和为这个值的路径数量。（因为可能好几条路径前缀和是同一个值。）。这里表示前缀和为0的路径有一条。（不这样做若某个节点的前缀和直接已经等于targetSum，此时反而会错过此路径）
        return recur(root, 0L);  //传入参数是根节点root，和root之前的前缀和0。
    }

    //recur函数，用于遍历二叉树，对每个节点，记录前缀和的同时，返回当前找到和为target的路径数量。传入的第二个参数curSum表示node节点之前的前缀和。
    private int recur(TreeNode node, Long curSum) {
        if (node == null) {
            return 0;
        }

        int res = 0;  //res记录路径数量。
        curSum += node.val;  //curSum记录前缀和，遍历到当前节点的时候就加上这个节点的值。

        res += prefixMap.getOrDefault(curSum - target, 0);  //res就是路径数量。curSum是根节点到当前节点的前缀和，如果哈希表中能找到之前存在过路径的前缀和为curSum - target，说明可以找到value条路径使其路径和为target。
        prefixMap.put(curSum, prefixMap.getOrDefault(curSum, 0) + 1);  //把当前节点的前缀和也加入到哈希表中，如果已经存在了就给value + 1

        int left = recur(node.left, curSum);  //再去遍历其左右子树继续记录前缀和并找可行路径。
        int right = recur(node.right, curSum);

        res = res + left + right;  //全都遍历完了在把所有找到的路径加起来就是总的路径数量。

        prefixMap.put(curSum, prefixMap.get(curSum) - 1);  //最后记得在哈希表中把已经找过的路径都去掉，即恢复状态。

        return res;
    }

}
